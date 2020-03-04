package edu.umsl.cs4020_project1_adamwilson

class ClassModel {
    companion object {
        @JvmStatic
        var sections: Array<Section> = arrayOf(
            Section("Food 3030: Advanced Ice Cream Tasting",
                "TU/TH",
                7,
                listOf(
                    Student("Bridget", "Unknown"),
                    Student("Sally", "Unknown"),
                    Student("John", "Unknown"),
                    Student("Ghengis", "Unknown"),
                    Student("Caesar", "Unknown"),
                    Student("Napoleon", "Unknown"),
                    Student("Alexander", "Unknown")
                )),

            Section("ZOOLOGY 1300: Basic Lupine Urology",
                "MO/TU/WE/TH/FR",
                9,
                listOf(
                    Student("Suzie", "Unknown"),
                    Student("Sally", "Unknown"),
                    Student("Sadie", "Unknown"),
                    Student("Sophie", "Unknown"),
                    Student("Sandy", "Unknown"),
                    Student("Tim", "Unknown"),
                    Student("Kim", "Unknown"),
                    Student("Jim", "Unknown"),
                    Student("Him", "Unknown")
                )),

            Section("TOOLS 4000: Studies in Ladder Maintenance",
                "MO/WE",
                5,
                listOf(
                    Student("Jill", "Unknown"),
                    Student("Gill", "Unknown"),
                    Student("Will", "Unknown"),
                    Student("Bill", "Unknown"),
                    Student("Jim", "Unknown")
                ))
        )
    }
}