package com.jetsetradio.live.data

import android.content.ContentResolver
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.support.v4.media.MediaBrowserCompat
import android.support.v4.media.MediaMetadataCompat
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jetsetradio.live.BuildConfig
import com.jetsetradio.live.R
import com.jetsetradio.live.extensions.*
import java.io.IOException
import java.util.*
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt


object MusicLibrary {
    //    private val musics = TreeMap<Int, MediaMetadataCompat>()
    //    private val albumRes = HashMap<Int, Int>()

    private var shuffleStation: Int = 0
    private var shuffle: Boolean = false
    private var currStation:Int = 1
    private var numstations:Int = 0

    // this holds a key int of a station to an array of metadata for each song
    private val musicMetadata = TreeMap<Int,Array<MediaMetadataCompat>>()
//    private val albumRes = HashMap<String, Int>()
//    private val stationDescriptions = HashMap<String, Int>()
    private val stationData = HashMap<String, IntArray>()

    // this holds a key int of a station to an array of sources for each song
//    private val musicFileNames = HashMap<Int, Array<String>>()

    init {

    }


    fun nextStation(){
        if(currStation == numstations-1){
            currStation = 1
        }else{
            currStation++
        }
        shuffleStation = currStation
    }

    fun prevStation(){
        if(currStation == 1){
            currStation = numstations-1
        }else{
            currStation--
        }
        shuffleStation = currStation
    }

    fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    // shuffles a stations music
    fun <T> Array<T>.shuffle(): Array<T> {
        for (index in this.indices) {
            val randomIndex = Random.nextInt(index+1)

            // Swap with the random position
            val temp = this[index]
            this[index] = this[randomIndex]
            this[randomIndex] = temp
        }

        return this
    }

    fun loadJetSetRadio(context: Context){
        val jsonFileString = getJsonDataFromAsset(context, "station_reference_list.json")
        //load music library
        val arrayTutorialType = object : TypeToken<Array<String>>() {}.type
        //get all station files
        val stationlist: Array<String> = Gson().fromJson(jsonFileString,arrayTutorialType)

        numstations = stationlist.size



        // this val holds all station image data
        val stationImageData = arrayOf(
                intArrayOf(R.drawable.classic, R.drawable.classic_description, R.drawable.classicwallpaper),
                intArrayOf(R.drawable.classic, R.drawable.classic_description, R.drawable.classicwallpaper),
                intArrayOf(R.drawable.future, R.drawable.future_description, R.drawable.futurewallpaper),
                intArrayOf(R.drawable.ultraremixes, R.drawable.ultraremixes_description, R.drawable.ultraremixeswallpaper),
                intArrayOf(R.drawable.lofi, R.drawable.lofi_description, R.drawable.lofiwallpaper),
                intArrayOf(R.drawable.ggs, R.drawable.ggs_description, R.drawable.ggswallpaper),
                intArrayOf(R.drawable.noisetanks, R.drawable.noisetanks_description, R.drawable.noisetankswallpaper),
                intArrayOf(R.drawable.poisonjam, R.drawable.poisonjam_description, R.drawable.poisonjamwallpaper),
                intArrayOf(R.drawable.rapid99, R.drawable.rapid99_description, R.drawable.rapid99wallpaper),
                intArrayOf(R.drawable.loveshockers, R.drawable.loveshockers_description, R.drawable.loveshockerswallpaper),
                intArrayOf(R.drawable.immortals, R.drawable.immortals_description, R.drawable.immortalswallpaper),
                intArrayOf(R.drawable.doomriders, R.drawable.doomriders_description, R.drawable.doomriderswallpaper),
                intArrayOf(R.drawable.goldenrhinos, R.drawable.goldenrhinos_description, R.drawable.goldenrhinoswallpaper),
                intArrayOf(R.drawable.memoriesoftokyoto, R.drawable.memoriesoftokyoto_description, R.drawable.memoriesoftokyotowallpaper),
                intArrayOf(R.drawable.kingforanotherday, R.drawable.kingforanotherday_description, R.drawable.kingforanotherdaywallpaper),
                intArrayOf(R.drawable.ollieking, R.drawable.ollieking_description, R.drawable.olliekingwallpaper),
                intArrayOf(R.drawable.toejamandearl, R.drawable.toejamandearl_description, R.drawable.toejamandearlwallpaper),
                intArrayOf(R.drawable.crazytaxi, R.drawable.crazytaxi_description, R.drawable.crazytaxiwallpaper),
                intArrayOf(R.drawable.hover, R.drawable.hover_description, R.drawable.hoverwallpaper),
                intArrayOf(R.drawable.butterflies, R.drawable.butterflies_description, R.drawable.butterflieswallpaper),
                intArrayOf(R.drawable.elaquent, R.drawable.elaquent_description, R.drawable.elaquentwallpaper),
                intArrayOf(R.drawable.revolution, R.drawable.revolution_description, R.drawable.revolutionwallpaper),
                intArrayOf(R.drawable.endofdays, R.drawable.endofdays_description, R.drawable.endofdayswallpaper),
                intArrayOf(R.drawable.summer, R.drawable.summer_description, R.drawable.summerwallpaper),
                intArrayOf(R.drawable.halloween, R.drawable.halloween_description, R.drawable.halloweenwallpaper),
                intArrayOf(R.drawable.christmas, R.drawable.christmas_description, R.drawable.christmaswallpaper)
                )


        // for all stations load the station playlist
        for ((sourceIdx, source) in stationlist.withIndex()) {
            // get teh station song list
            var songlist: Array<String> = Gson().fromJson(getJsonDataFromAsset(context,source),arrayTutorialType)

            songlist = songlist.shuffle()

            // load metadata for all songs
            val MetadataArray =  Array<MediaMetadataCompat>(songlist.size){
                i-> createMetadata(i,songlist.get(i),source)
            }
//            albumRes[source] = stationIcons[sourceIdx]
//            stationDescriptions[source] = stationDesc[sourceIdx]

            stationData[source] = stationImageData[sourceIdx]

            musicMetadata[sourceIdx] = MetadataArray
        }
    }


    private fun getAlbumArtUri(resName: String): String =
            "${ContentResolver.SCHEME_ANDROID_RESOURCE}://${BuildConfig.APPLICATION_ID}/drawable/$resName"


    fun getStationBitmaps(context: Context, station: String): Array<Bitmap?>? {
        if (stationData.containsKey(station)) {
            val stationImagearray = stationData[station] ?: return null
            val bitmapArray = arrayOfNulls<Bitmap?>(stationImagearray.size)
            for((idx,image) in stationImagearray.withIndex()){
                bitmapArray[idx] = BitmapFactory.decodeResource(context.resources, image)
            }
            return bitmapArray
        }
        return null
    }


    // a helper function to create metadata of a single song
    private fun createMetadata(id:Int,song:String,station:String): MediaMetadataCompat {
        //  the song title and artist can be derived from the src
        var artist: String = "Unknown"
        var title: String
        // split by " - "
        val parts: Array<String> = song.split(" - ").toTypedArray()
        // if no dash
        if (parts.size != 2) {
            // artist is unknown
            // get title from last slash and remove.mp3
            title = parts[0].split("/").toTypedArray()[6]
            title = title.substring(0, title.length - 4)
        } else {
            // get the artist from the last slash
            artist = parts[0].split("/").toTypedArray()[6]
            // get the title and remove the .mp3
            title = parts[1].substring(0, parts[1].length - 4)
        }
        val mediaMetadata = MediaMetadataCompat.Builder().apply {
            this.id = id.toString()
            this.MEDIA_URI = song
            this.title = title
            this.artist = artist
            this.genre = station
        }.build()

        return mediaMetadata
    }

    fun getRoot(): String = "Root"


    fun getMediaItems(): MutableList<MediaBrowserCompat.MediaItem> {
        val result = mutableListOf<MediaBrowserCompat.MediaItem>()
        musicMetadata[currStation]?.forEach {
            val mediaItem = MediaBrowserCompat.MediaItem(
                    it.description, MediaBrowserCompat.MediaItem.FLAG_PLAYABLE
            )
            result.add(mediaItem)
        }
        return result
    }



    fun getMusicMetadata(context: Context, songID: Int): MediaMetadataCompat? {
        // 1/20 chance to play bump
        when {
            Random.nextInt(0,19) == 0 -> {
                return musicMetadata[0]?.get(songID)?.let {
                    val musicMetadataBuilder = MediaMetadataCompat.Builder().apply {
                        this.id = it.id
                        this.MEDIA_URI = it.MEDIA_URI
//                        this.album = it.album
                        this.artist = it.artist
                        this.genre = it.genre
                        this.title = it.title
//                this.duration = it.duration
//                getAlbumBitmap(context, musicId)?.also { albumArt -> this.albumArt = albumArt }
                    }
                    musicMetadataBuilder.build()
                }
            }
            shuffle -> {
                val randStation = nextInt(1, numstations)

                currStation = randStation
                shuffleStation = randStation

                val newsong = musicMetadata[currStation]?.size?.let { nextInt(0, it) }
                return newsong?.let {
                    musicMetadata[currStation]?.get(it)?.let {
                        val musicMetadataBuilder = MediaMetadataCompat.Builder().apply {
                            this.id = it.id
        //                        this.album = it.album
                            this.artist = it.artist
                            this.MEDIA_URI = it.MEDIA_URI
        //                        this.albumArtUri = it.albumArtUri.toString()
                            this.genre = it.genre
                            this.title = it.title
        //                this.duration = it.duration
        //                getAlbumBitmap(context, musicId)?.also { albumArt -> this.albumArt = albumArt }
                        }
                        musicMetadataBuilder.build()
                    }
                }
            }
            else -> {
                return musicMetadata[currStation]?.get(songID)?.let {
                    val musicMetadataBuilder = MediaMetadataCompat.Builder().apply {
                        this.id = it.id
//                        this.album = it.album
                        this.artist = it.artist
                        this.MEDIA_URI = it.MEDIA_URI
//                        this.albumArtUri = it.albumArtUri.toString()
                        this.genre = it.genre
                        this.title = it.title
//                this.duration = it.duration
//                getAlbumBitmap(context, musicId)?.also { albumArt -> this.albumArt = albumArt }
                    }
                    musicMetadataBuilder.build()
                }
            }
        }
    }


    fun getNextMusicFileName(it: String): MediaMetadataCompat? {
        if(it.toInt() == musicMetadata[currStation]?.size?.minus(1) ?: 0){
            return musicMetadata[currStation]?.get(0)
        }
        return musicMetadata[currStation]?.get(it.toInt()+1)
    }

    fun getNumSongs(): Int? {
        return musicMetadata[currStation]?.size
    }

    fun getShuffle(): Boolean{
        return this.shuffle
    }

    fun setShuffle(shuffle: Boolean){
        this.shuffle = shuffle
    }


}
