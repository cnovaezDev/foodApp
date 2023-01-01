package cnovaez.dev.foodapp.utils.data_types

/**
 ** Created by Carlos A. Novaez Guerrero on 01/01/2023 15:08
 ** cnovaez.dev@outlook.com
 **/
enum class CousineType {
    Asian, British, Caribbean, CentralEurope, Chinese, EasternEurope,
    French, Indian, Italian, Japanese, Kosher, Mediterranean, Mexican,
    MiddleEastern, Nordic, SouthAmerican, SouthEastAsian, American;

    override fun toString(): String {
       return when (this) {
            CentralEurope -> "Central Europe"
            EasternEurope -> "Eastern Europe"
            MiddleEastern -> "Middle Eastern"
            SouthAmerican -> "South American"
            SouthEastAsian -> "South East Asian"
            else -> {
                super.toString()
            }
        }
    }
}