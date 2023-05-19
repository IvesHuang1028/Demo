package com.cathaywork.demo

import com.cathaywork.demo.data.model.AttractionData
import com.google.gson.Gson
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    var jsonStr = "{\n" +
            "  \"total\": 425,\n" +
            "  \"data\": [\n" +
            "    {\n" +
            "      \"id\": 548,\n" +
            "      \"name\": \"Yangmingshan Guangfu Building\",\n" +
            "      \"name_zh\": null,\n" +
            "      \"open_status\": 1,\n" +
            "      \"introduction\": \"A symbol of Yangmingshan National Park, the Xinhai-Guangfu Building is cozily nestled in thick woods. This sumptuously decorated, two-story Chinoiserie structure was completed in 1971 to mark the 60th anniversary of the Xinhai Revolution. Located at the geological center of Yangmingshan National Park, this building offers a spectacular view of the Taipei Basin in the distance. A pond in front of the building, observable from the second-floor veranda, is children&rsquo;s favorite as they are allowed to feed the varicolored carp in it. Adding quaint and solemnly elegant appeal to Gaungfu Building are exquisite carvings, paintings and numerous other typical Chinese architectural details that subtly made references to literature classics. When the flowers are in full bloom, the building becomes an island in a sea of cherry blossom petals. So just indulge yourself in this phenomenon by lingering around the circuitous corridors while appreciating the interplay between blossoms and the elusive mountain mist.\",\n" +
            "      \"open_time\": \"9:00 AM-5:00 PM, daily\",\n" +
            "      \"zipcode\": \"112\",\n" +
            "      \"distric\": \"Beitou Dist.\",\n" +
            "      \"address\": \"No. 26, Section 2, Hushan Road,Beitou Dist.,Taipei City 112\",\n" +
            "      \"tel\": \"+886-2-28618325\",\n" +
            "      \"fax\": \"\",\n" +
            "      \"email\": \"\",\n" +
            "      \"months\": \"01,07,02,08,03,09,04,10,05,11,06,12\",\n" +
            "      \"nlat\": 25.15928,\n" +
            "      \"elong\": 121.54012,\n" +
            "      \"official_site\": \"\",\n" +
            "      \"facebook\": \"\",\n" +
            "      \"ticket\": \"\",\n" +
            "      \"remind\": \"\",\n" +
            "      \"staytime\": \"\",\n" +
            "      \"modified\": \"2023-05-17 11:03:22 +08:00\",\n" +
            "      \"url\": \"https://www.travel.taipei/en/attraction/details/548\",\n" +
            "      \"category\": [\n" +
            "        {\n" +
            "          \"id\": 13,\n" +
            "          \"name\": \"Historic Sites\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"id\": 15,\n" +
            "          \"name\": \"Art and Cultural Centers\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"id\": 18,\n" +
            "          \"name\": \"Public Art\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"target\": [\n" +
            "        {\n" +
            "          \"id\": 61,\n" +
            "          \"name\": \"Family\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"id\": 62,\n" +
            "          \"name\": \"Campus teaching\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"service\": [\n" +
            "        {\n" +
            "          \"id\": 146,\n" +
            "          \"name\": \"Toilets\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"friendly\": [],\n" +
            "      \"images\": [\n" +
            "        {\n" +
            "          \"src\": \"https://www.travel.taipei/image/123992\",\n" +
            "          \"subject\": \"\",\n" +
            "          \"ext\": \".jpg\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"src\": \"https://www.travel.taipei/image/123993\",\n" +
            "          \"subject\": \"\",\n" +
            "          \"ext\": \".jpg\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"src\": \"https://www.travel.taipei/image/123994\",\n" +
            "          \"subject\": \"\",\n" +
            "          \"ext\": \".jpg\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"src\": \"https://www.travel.taipei/image/123995\",\n" +
            "          \"subject\": \"\",\n" +
            "          \"ext\": \".jpg\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"src\": \"https://www.travel.taipei/image/123991\",\n" +
            "          \"subject\": \"\",\n" +
            "          \"ext\": \".jpg\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"files\": [],\n" +
            "      \"links\": []\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 538,\n" +
            "      \"name\": \"Beitou Library\",\n" +
            "      \"name_zh\": null,\n" +
            "      \"open_status\": 1,\n" +
            "      \"introduction\": \"Apart from being famous for its hot springs, Beitou is also home to Taiwan&rsquo;s first &ldquo;green&rdquo; library. This distinctive structure is located in the lush green environs of Beitou Hot Spring Park, near the Beitou Hot Spring Museum.\\r\\n\\r\\nThis library was the first building in Taiwan to receive the certification of &ldquo;Green Building&rdquo;. The structure makes generous use of French windows and natural light, and blends in with the surrounding environment. Built mainly of wood and steel, it resembles a large treehouse just waiting to welcome visitors.\\r\\n\\r\\nBeitou Library is &ldquo;green&rdquo; from inside to outside! Part of the roof is covered in solar panels, which can store up to 16KW of power. The wooden balcony railing is also eco-friendly; its vertical design conserves energy by reducing the amount of heat-causing rays allowed to enter the rooms. Rainwater collected by the sloping roof&rsquo;s drainage system is used to water the library&rsquo;s plants and flush the toilets. Eco-friendly paint was also used, to reduce the amount of toxins released into the environment.\\r\\n\\r\\nWhen you come to Beitou, besides having a nice soak in the hot springs, you can also visit the Beitou Library for some &ldquo;forest bathing&rdquo;&mdash;enjoying a good book surrounded by lush greenery, that is!\",\n" +
            "      \"open_time\": \"\",\n" +
            "      \"zipcode\": \"112\",\n" +
            "      \"distric\": \"Beitou Dist.\",\n" +
            "      \"address\": \"No.251, Guangming Rd.,Beitou Dist.,Taipei City 112\",\n" +
            "      \"tel\": \"+886-2-28977682\",\n" +
            "      \"fax\": \"+886-2-28978538\",\n" +
            "      \"email\": \"\",\n" +
            "      \"months\": \"01,07,02,08,03,09,04,10,05,11,06,12\",\n" +
            "      \"nlat\": 25.13652,\n" +
            "      \"elong\": 121.50638,\n" +
            "      \"official_site\": \"\",\n" +
            "      \"facebook\": \"\",\n" +
            "      \"ticket\": \"\",\n" +
            "      \"remind\": \"\",\n" +
            "      \"staytime\": \"\",\n" +
            "      \"modified\": \"2023-05-17 10:55:26 +08:00\",\n" +
            "      \"url\": \"https://www.travel.taipei/en/attraction/details/538\",\n" +
            "      \"category\": [\n" +
            "        {\n" +
            "          \"id\": 15,\n" +
            "          \"name\": \"Art and Cultural Centers\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"id\": 19,\n" +
            "          \"name\": \"Family Activities\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"target\": [\n" +
            "        {\n" +
            "          \"id\": 61,\n" +
            "          \"name\": \"Family\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"service\": [\n" +
            "        {\n" +
            "          \"id\": 146,\n" +
            "          \"name\": \"Toilets\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"friendly\": [],\n" +
            "      \"images\": [],\n" +
            "      \"files\": [],\n" +
            "      \"links\": []\n" +
            "    }\n" +
            "]}"

@Test
    fun testJSONPaserData() {
        /**
         *  檢查 Json Parser 出來的資料正確性
        **/
        var data :AttractionData = Gson().fromJson(jsonStr, AttractionData::class.java)
        assertEquals("Yangmingshan Guangfu Building",data.data[0].name)
    }
}