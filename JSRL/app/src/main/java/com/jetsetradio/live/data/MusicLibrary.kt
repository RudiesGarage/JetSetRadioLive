package com.jetsetradio.live.data

import android.content.ContentResolver
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v4.media.MediaBrowserCompat
import android.support.v4.media.MediaMetadataCompat
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jetsetradio.live.BuildConfig
import com.jetsetradio.live.R
import com.jetsetradio.live.extensions.*
import java.io.IOException
import java.util.*
import kotlin.collections.HashMap
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt


object MusicLibrary {

    private var shuffleStation: Int = 0
    private var currStation:Int = 0


    // this holds a key int of a station to an array of metadata for each song
    private val musicMetadata = TreeMap<Int,Array<MediaMetadataCompat>>()
    private var bumpsMetadata: Array<MediaMetadataCompat>? = null
    // this val holds all station image data
    private val stationData = StationManager()

    init {

    }

    fun getBumps(): MutableList<MediaBrowserCompat.MediaItem> {
        val result = mutableListOf<MediaBrowserCompat.MediaItem>()
        var i =0;
        bumpsMetadata?.forEach {

            val mediaItem = MediaBrowserCompat.MediaItem(
                    it.description, MediaBrowserCompat.MediaItem.FLAG_PLAYABLE
            )
            result.add(mediaItem)
            i++

        }
        return result
    }


    fun getStationData(): StationManager{
        return this.stationData
    }

    fun getCurrStation():Int{
        return currStation
    }

    fun getCurrStationSize(): Int? {
        return musicMetadata[currStation]?.size
    }

    fun nextStation(): MutableList<MediaBrowserCompat.MediaItem> {
        if(currStation == stationData.numStations()-1){
            currStation = 0
        }else{
            currStation++
        }
        shuffleStation = currStation

        return this.getMediaItems()
    }

    fun prevStation(): MutableList<MediaBrowserCompat.MediaItem> {
        if(currStation == 0 ){
            currStation = stationData.numStations()-1
        }else{
            currStation--
        }
        shuffleStation = currStation
        return this.getMediaItems()
    }

    fun getNumStations():Int{
        return stationData.numStations()
    }

    fun anyStation(stationID: Int): MutableList<MediaBrowserCompat.MediaItem>{
        currStation = stationID
        shuffleStation = currStation
        return this.getMediaItems()
    }


    private fun getJsonDataFromAsset(context: Context, fileName: String): String? {
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

    //TODO load bumps separately
    // load all music within station_reference_list.json
    fun loadJetSetRadio(context: Context){
        val jsonFileString = getJsonDataFromAsset(context, "station_reference_list.json")
        //load music library
        val arrayTutorialType = object : TypeToken<Array<String>>() {}.type
        //get all station files
        val stationlist: Array<String> = Gson().fromJson(jsonFileString,arrayTutorialType)

        // for all stations load the station playlist
        for ((sourceIdx, source) in stationlist.withIndex()) {
            // get teh station song list
            var songlist: Array<String> = Gson().fromJson(getJsonDataFromAsset(context,source),arrayTutorialType)

            songlist = songlist.shuffle()

            // load metadata for all songs
            val MetadataArray =  Array(songlist.size){
                i-> createMetadata(i, songlist[i],sourceIdx)
            }

            musicMetadata[sourceIdx] = MetadataArray
        }

        //Load BUmps

        // get teh station song list
        var songlist: Array<String> = Gson().fromJson(getJsonDataFromAsset(context,"bumps.json"),arrayTutorialType)

        songlist = songlist.shuffle()

        // load metadata for all songs
        val MetadataArray =  Array(songlist.size){
            i-> createBumpMetadata(i, songlist[i])
        }

        bumpsMetadata = MetadataArray
    }


    private fun getAlbumArtUri(resName: String): String =
            "${ContentResolver.SCHEME_ANDROID_RESOURCE}://${BuildConfig.APPLICATION_ID}/drawable/$resName"


    fun getStationBackgroundBitmap(context: Context, stationID: Int): Bitmap? {
        val stationImage = stationData.getStation(stationID).getStationBackground()
        return BitmapFactory.decodeResource(context.resources, stationImage)
    }




    // a helper function to create metadata of a single song
    private fun createMetadata(songID:Int,song:String,stationID: Int): MediaMetadataCompat {
        //  the song title and artist can be derived from the src
        var artist = "Unknown"
        var title: String
        // split by " - "
        val parts: Array<String> = song.split(" - ").toTypedArray()
        // if no dash
        if (parts.size != 2) {
            // artist is unknown
            // get title from last slash and remove.mp3
            title = parts[0].split("/").toTypedArray()[6]
            if(title.length>4){
                title = title.substring(0, title.length - 4)
            }
        } else {
            // get the artist from the last slash
            artist = parts[0].split("/").toTypedArray()[6]
            // get the title and remove the .mp3
            title = parts[1].substring(0, parts[1].length - 4)
        }
        val mediaMetadata = MediaMetadataCompat.Builder().apply {
            this.id = songID.toString()
            this.MEDIA_URI = song
            this.title = title
            this.artist = artist
            this.genre = stationID.toString()
        }.build()

        return mediaMetadata
    }

    // a helper function to create metadata of a single song
    private fun createBumpMetadata(songID:Int,song:String): MediaMetadataCompat {
        //  the song title and artist can be derived from the src
        var artist = "Bump"
        var title: String
        // split by " - "
        val parts: Array<String> = song.split(" - ").toTypedArray()
        // if no dash
        if (parts.size != 2) {
            // artist is unknown
            // get title from last slash and remove.mp3
            title = parts[0].split("/").toTypedArray()[6]
            if(title.length>4){
                title = title.substring(0, title.length - 4)
            }
        } else {
            // get the artist from the last slash
            artist = parts[0].split("/").toTypedArray()[6]
            // get the title and remove the .mp3
            title = parts[1].substring(0, parts[1].length - 4)
        }
        val mediaMetadata = MediaMetadataCompat.Builder().apply {
            this.id = songID.toString()
            this.MEDIA_URI = song
            this.title = title
            this.artist = artist
            this.genre = "bump"
        }.build()

        return mediaMetadata
    }
    fun getRoot(): String = "Root"


    fun getMediaItems(): MutableList<MediaBrowserCompat.MediaItem> {
        val result = mutableListOf<MediaBrowserCompat.MediaItem>()
        var i =0;
            musicMetadata[currStation]?.forEach {

                    val mediaItem = MediaBrowserCompat.MediaItem(
                            it.description, MediaBrowserCompat.MediaItem.FLAG_PLAYABLE
                    )
                    result.add(mediaItem)
                    i++

            }
        return result
    }

    fun getAllMediaItems(): MutableList<MediaBrowserCompat.MediaItem> {
        val result = mutableListOf<MediaBrowserCompat.MediaItem>()
        for(i in 0..stationData.numStations()){
            musicMetadata[i]?.forEach {
                val mediaItem = MediaBrowserCompat.MediaItem(
                        it.description, MediaBrowserCompat.MediaItem.FLAG_PLAYABLE
                )
                result.add(mediaItem)
            }
        }
        return result
    }



    fun getMusicMetadata(songID: Int): MediaMetadataCompat? {
        val stationID: Int = this.currStation;

        if(songID >= musicMetadata[stationID]?.size!!){
            return this.getRandomSong()
        }


        return musicMetadata[stationID]?.get(songID)?.let {
            val musicMetadataBuilder = MediaMetadataCompat.Builder().apply {

                this.id = it.id
                this.MEDIA_URI = it.MEDIA_URI
//                        this.album = it.album
                this.artist = it.artist
                // make sure the  stays in the current station
                this.genre = musicMetadata[currStation]?.get(0)?.genre ?: it.genre
                this.title = it.title
//                this.duration = it.duration
//                getAlbumBitmap(context, musicId)?.also { albumArt -> this.albumArt = albumArt }
            }
            musicMetadataBuilder.build()
        }
    }



    // get random song in the current station
    private fun getRandomSong():MediaMetadataCompat?{
        val randsong = nextInt(1, musicMetadata[this.currStation]?.size!!)-1
        return getMusicMetadata(randsong)
    }


    fun getNextMusicFileName(it: String): MediaMetadataCompat? {
        if(it.toInt() == musicMetadata[currStation]?.size?.minus(1) ?: 0){
            return musicMetadata[currStation]?.get(0)
        }
        return musicMetadata[currStation]?.get(it.toInt()+1)
    }

    fun getGenre(): String? {
       return musicMetadata[currStation]?.get(0)?.genre
    }

    fun getNumSongs(): Int? {
        return musicMetadata[currStation]?.size
    }



}
