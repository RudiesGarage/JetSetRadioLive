package com.jetsetradio.live.data

import com.jetsetradio.live.R
import java.util.*
import kotlin.collections.ArrayList

// this class loads and handles all the station logic
class StationManager(){
    private val stationList = ArrayList<Station>()

    init{
        //Load all the stations
        addStation(Station("Classic","#ffff66",R.drawable.classic, R.drawable.classic_description, R.drawable.classicwallpaper))
        addStation(Station("Future","#cccccc",R.drawable.future, R.drawable.future_description, R.drawable.futurewallpaper))
        addStation(Station("Lo-Fi","#f7e6ff",R.drawable.lofi, R.drawable.lofi_description, R.drawable.lofiwallpaper))
        addStation(Station("GGs","#00b300",R.drawable.ggs, R.drawable.ggs_description, R.drawable.ggswallpaper))
        addStation(Station("Noise Tanks","#a6a6a6",R.drawable.noisetanks, R.drawable.noisetanks_description, R.drawable.noisetankswallpaper))
        addStation(Station("Poison Jam","#660066",R.drawable.poisonjam, R.drawable.poisonjam_description, R.drawable.poisonjamwallpaper))
        addStation(Station("Rapid99","#ff99ff",R.drawable.rapid99, R.drawable.rapid99_description, R.drawable.rapid99wallpaper))
        addStation(Station("Love Shockers","#ff0066",R.drawable.loveshockers, R.drawable.loveshockers_description, R.drawable.loveshockerswallpaper))
        addStation(Station("Immortals","#ffcc00",R.drawable.immortals, R.drawable.immortals_description, R.drawable.immortalswallpaper))
        addStation(Station("Doom Riders","#cc0000",R.drawable.doomriders, R.drawable.doomriders_description, R.drawable.doomriderswallpaper))
        addStation(Station("Golden Rhinos","#ffff80",R.drawable.goldenrhinos, R.drawable.goldenrhinos_description, R.drawable.goldenrhinoswallpaper))
        addStation(Station("KFAD","#66ff33",R.drawable.kingforanotherday, R.drawable.siiva_description, R.drawable.kfad_wallpaper))
        addStation(Station("2Mello","#00b300",R.drawable.memoriesoftokyoto, R.drawable.memoriesoftokyoto_description, R.drawable.memoriesoftokyotowallpaper))
        addStation(Station("Dj Chidow","#cc00cc",R.drawable.djchidow_icon, R.drawable.djchidow_description, R.drawable.djchidow_wallpaper))
        addStation(Station("Jetmash","#b82e8a",R.drawable.jetmash_icon, R.drawable.jetmash_desc, R.drawable.jetmash_wallpaper))
        addStation(Station("Ultra Remixes","#ffff4d",R.drawable.ultraremixes, R.drawable.ultraremixes_description, R.drawable.ultraremixeswallpaper))
        addStation(Station("Ollie King","#999900",R.drawable.ollieking, R.drawable.ollieking_description, R.drawable.olliekingwallpaper))
        addStation(Station("Toe Jam & Earl","#00cccc",R.drawable.toejamandearl, R.drawable.toejamandearl_description, R.drawable.toejamandearlwallpaper))
        addStation(Station("Crazy Taxi","#e67300",R.drawable.crazytaxi, R.drawable.crazytaxi_description, R.drawable.crazytaxiwallpaper))
        addStation(Station("Hover","#6666ff",R.drawable.hover, R.drawable.hover_description, R.drawable.hoverwallpaper))
        addStation(Station("Butterflies","#e6b3ff",R.drawable.butterflies, R.drawable.butterflies_description, R.drawable.butterflieswallpaper))
        addStation(Station("Elaquent","#b3b300",R.drawable.elaquent, R.drawable.elaquent_description, R.drawable.elaquentwallpaper))
        addStation(Station("Revolution","#663300",R.drawable.revolution, R.drawable.revolution_description, R.drawable.revolutionwallpaper))
        addStation(Station("End of Days","#4d4d4d",R.drawable.endofdays, R.drawable.endofdays_description, R.drawable.endofdayswallpaper))
        addStation(Station("Next Gen","#f2f2f2",R.drawable.future_gen_icon, R.drawable.future_gen_description, R.drawable.future_gen_wallpaper))
        addStation(Station("Ganja","#33cc33",R.drawable.ganjah_icon, R.drawable.ganjah_desc, R.drawable.ganjah_wallpaper))

        //load seasonal tracks during correct season
        val cal: Calendar = Calendar.getInstance()
        when(cal.get(Calendar.MONTH)){
            1,10,11 -> addStation(Station("Christmas","#ffffff",R.drawable.christmas, R.drawable.christmas_description, R.drawable.christmaswallpaper))
            8,9 -> addStation(Station("Halloween","#ff8000",R.drawable.halloween, R.drawable.halloween_description, R.drawable.halloweenwallpaper))
            else -> addStation(Station("Summer","#ffffb3",R.drawable.summer, R.drawable.summer_description, R.drawable.summerwallpaper))
        }
    }

    // add a station to the list
    private fun addStation(newStation: Station){
        stationList.add(newStation)
    }

    // get a station from an id number
    fun getStation(id: Int): Station{
        return this.stationList[id]
    }

    // Get a specific station from a string
    fun getStation(id: String): Station? {
        for(station: Station in this.stationList){
            if(station.getStationName() == id){
                return station
            }
        }
        return null
    }

    // return the number of loaded stations
    fun numStations():Int{
        return this.stationList.size
    }

    // load information needed for the slider
    fun getAllIcons():ArrayList<ArrayList<Int>>{
        val numStation = ArrayList<ArrayList<Int>>()
        for(station:Station in this.stationList){
            val imgStation = ArrayList<Int>()
            imgStation.add(station.getStationIcon())
            imgStation.add(station.getStationDesc())
            numStation.add(imgStation)
        }
        return numStation
    }

    // Load information needed for the quick select fragment
    fun getQuickSelectData():ArrayList<ArrayList<Any>>{
        val numStation = ArrayList<ArrayList<Any>>()
        for(station:Station in this.stationList){
            val imgStation = ArrayList<Any>()
            imgStation.add(station.getStationName())
            imgStation.add(station.getStationIcon())
            imgStation.add(station.getStationColor())
            numStation.add(imgStation)
        }
        return numStation
    }




}