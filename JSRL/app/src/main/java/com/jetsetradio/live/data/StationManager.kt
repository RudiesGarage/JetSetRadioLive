package com.jetsetradio.live.data

import android.graphics.Bitmap
import com.jetsetradio.live.R

class StationManager(){
    private val stationList = ArrayList<Station>()

    init{
        //Load all the stations
        addStation(Station("Classic",numStations(),R.drawable.classic, R.drawable.classic_description, R.drawable.classicwallpaper))
        addStation(Station("Future",numStations(),R.drawable.future, R.drawable.future_description, R.drawable.futurewallpaper))
        addStation(Station("Lo-Fi",numStations(),R.drawable.lofi, R.drawable.lofi_description, R.drawable.lofiwallpaper))
        addStation(Station("GGs",numStations(),R.drawable.ggs, R.drawable.ggs_description, R.drawable.ggswallpaper))
        addStation(Station("Noise Tanks",numStations(),R.drawable.noisetanks, R.drawable.noisetanks_description, R.drawable.noisetankswallpaper))
        addStation(Station("Poison Jam",numStations(),R.drawable.poisonjam, R.drawable.poisonjam_description, R.drawable.poisonjamwallpaper))
        addStation(Station("Rapid99",numStations(),R.drawable.rapid99, R.drawable.rapid99_description, R.drawable.rapid99wallpaper))
        addStation(Station("Love Shockers",numStations(),R.drawable.loveshockers, R.drawable.loveshockers_description, R.drawable.loveshockerswallpaper))
        addStation(Station("Immortals",numStations(),R.drawable.immortals, R.drawable.immortals_description, R.drawable.immortalswallpaper))
        addStation(Station("Doom Riders",numStations(),R.drawable.doomriders, R.drawable.doomriders_description, R.drawable.doomriderswallpaper))
        addStation(Station("Golden Rhinos",numStations(),R.drawable.goldenrhinos, R.drawable.goldenrhinos_description, R.drawable.goldenrhinoswallpaper))
        addStation(Station("KFAD",numStations(),R.drawable.kingforanotherday, R.drawable.siiva_description, R.drawable.kfad_wallpaper))
        addStation(Station("2Mello",numStations(),R.drawable.memoriesoftokyoto, R.drawable.memoriesoftokyoto_description, R.drawable.memoriesoftokyotowallpaper))
        addStation(Station("Dj Chidow",numStations(),R.drawable.djchidow_icon, R.drawable.djchidow_description, R.drawable.djchidow_wallpaper))
        addStation(Station("Jetmash",numStations(),R.drawable.jetmash_icon, R.drawable.jetmash_desc, R.drawable.jetmash_wallpaper))
        addStation(Station("Ultra Remixes",numStations(),R.drawable.ultraremixes, R.drawable.ultraremixes_description, R.drawable.ultraremixeswallpaper))
        addStation(Station("Ollie King",numStations(),R.drawable.ollieking, R.drawable.ollieking_description, R.drawable.olliekingwallpaper))
        addStation(Station("Toe Jam & Earl",numStations(),R.drawable.toejamandearl, R.drawable.toejamandearl_description, R.drawable.toejamandearlwallpaper))
        addStation(Station("Crazy Taxi",numStations(),R.drawable.crazytaxi, R.drawable.crazytaxi_description, R.drawable.crazytaxiwallpaper))
        addStation(Station("Hover",numStations(),R.drawable.hover, R.drawable.hover_description, R.drawable.hoverwallpaper))
        addStation(Station("Butterflies",numStations(),R.drawable.butterflies, R.drawable.butterflies_description, R.drawable.butterflieswallpaper))
        addStation(Station("Elaquent",numStations(),R.drawable.elaquent, R.drawable.elaquent_description, R.drawable.elaquentwallpaper))
        addStation(Station("Revolution",numStations(),R.drawable.revolution, R.drawable.revolution_description, R.drawable.revolutionwallpaper))
        addStation(Station("End of Days",numStations(),R.drawable.endofdays, R.drawable.endofdays_description, R.drawable.endofdayswallpaper))
        addStation(Station("Next Gen",numStations(),R.drawable.future_gen_icon, R.drawable.future_gen_description, R.drawable.future_gen_wallpaper))
        addStation(Station("Ganja",numStations(),R.drawable.ganjah_icon, R.drawable.ganjah_desc, R.drawable.ganjah_wallpaper))

        //TODO load seasonal tracks during correct season
        addStation(Station("Summer",numStations(),R.drawable.summer, R.drawable.summer_description, R.drawable.summerwallpaper))
        addStation(Station("Halloween",numStations(),R.drawable.halloween, R.drawable.halloween_description, R.drawable.halloweenwallpaper))
        addStation(Station("Christmas",numStations(),R.drawable.christmas, R.drawable.christmas_description, R.drawable.christmaswallpaper))
    }

    private fun addStation(newStation: Station){
        stationList.add(newStation)
    }

    fun getStation(id: Int): Station{
        return this.stationList[id]
    }

    fun getStation(id: String): Station? {
        for(station: Station in this.stationList){
            if(station.getStationName() == id){
                return station
            }
        }
        return null
    }


    fun numStations():Int{
        return this.stationList.size
    }

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

    fun getQuickSelectData():ArrayList<ArrayList<Any>>{
        val numStation = ArrayList<ArrayList<Any>>()
        for(station:Station in this.stationList){
            val imgStation = ArrayList<Any>()
            imgStation.add(station.getStationName())
            imgStation.add(station.getStationIcon())
            numStation.add(imgStation)
        }
        return numStation
    }




}