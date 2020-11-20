package com.example.gamerecommendations
import kotlinx.android.synthetic.main.activity_main.*

//Data Class
data class GameData(var name: String = "", var url: String = "") {
    fun suggestGame(gameNumber: Int) {
        setGameName(gameNumber)
        setGameURL(gameNumber)
    }

    //Set the name based on the number
    private fun setGameName(gameNumber: Int){
        when (gameNumber) {
            0 -> name = "Okami"
            1 -> name = "The Legend of Zelda"
            2 -> name = "Devil May Cry V"
            3 -> name = "No More Heroes"
            4 -> name = "Undertale"
            5 -> name = "Earthbound"
            6 -> name = "The Last of Us"
            7 -> name = "Final Fantasy VII"
            8 -> name = "Journey"
            9 -> name = "Splatoon"
            10 -> name = "Nier Automata"
            11 -> name = "Transistor"
            12 -> name = "Little Big Planet 3"
            13 -> name = "Mario Odyssey"
            14 -> name = "Little Nightmares"
            15 -> name = "Hollow Knight"
            16 -> name = "Ori & The Blind Forest"
            17 -> name = "Megaman ZX"
            18 -> name = "Indivisible"
            19 -> name = "Celeste"
            20 -> name = "Sonic Mania"
            21 -> name = "Super Metroid"
            22 -> name = "Castlevania"
            23 -> name = "Cuphead"
            else -> name = "a fun game"
        }
    }

    //Set the YouTube video URL based on the number
    private fun setGameURL(gameNumber: Int){
        when (gameNumber) {
            0 -> url = "https://www.youtube.com/watch?v=RhnhRfTzRnw"
            1 -> url = "https://www.youtube.com/watch?v=zw47_q9wbBE"
            2 -> url = "https://www.youtube.com/watch?v=GL4tQAN-bCY"
            3 -> url = "https://www.youtube.com/watch?v=jumf7jtB9x4"
            4 -> url = "https://www.youtube.com/watch?v=1Hojv0m3TqA"
            5 -> url = "https://www.youtube.com/watch?v=vGOEMCG2Ll4"
            6 -> url = "https://www.youtube.com/watch?v=W01L70IGBgE"
            7 -> url = "https://www.youtube.com/watch?v=utVE4aUKYuY"
            8 -> url = "https://www.youtube.com/watch?v=mU3nNT4rcFg"
            9 -> url = "https://www.youtube.com/watch?v=8L54s2m1dPs"
            10 -> url = "https://www.youtube.com/watch?v=wJxNhJ8fjFk"
            11 -> url = "https://www.youtube.com/watch?v=pJmtn6JP7Ug"
            12 -> url = "https://www.youtube.com/watch?v=ymCDdrMKPrY"
            13 -> url = "https://www.youtube.com/watch?v=5kcdRBHM7kM"
            14 -> url = "https://www.youtube.com/watch?v=aOadxZBsPiA"
            15 -> url = "https://www.youtube.com/watch?v=UAO2urG23S4"
            16 -> url = "https://www.youtube.com/watch?v=cklw-Yu3moE"
            17 -> url = "https://www.youtube.com/watch?v=agKnMZfvKZk"
            18 -> url = "https://www.youtube.com/watch?v=wqoGLI8dPYE"
            19 -> url = "https://www.youtube.com/watch?v=iofYDsA2yqg"
            20 -> url = "https://www.youtube.com/watch?v=VYQNnrccbj8"
            21 -> url = "https://www.youtube.com/watch?v=FByXeWTe_50"
            22 -> url = "https://www.youtube.com/watch?v=Rm2KKmud2MA"
            23 -> url = "https://www.youtube.com/watch?v=NN-9SQXoi50"
            else -> url = "https://www.metacritic.com/browse/games/score/metascore/all/"
        }
    }
}

