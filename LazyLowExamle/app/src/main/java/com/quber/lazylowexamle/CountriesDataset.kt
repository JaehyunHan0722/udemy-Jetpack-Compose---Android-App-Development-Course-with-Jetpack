package com.quber.lazycolumnexapmle

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.quber.lazylowexamle.R

@Composable
fun retrieveCountries(): SnapshotStateList<CountryModel> {
    val countryList = remember {
        mutableStateListOf(
            CountryModel(1, "Korea", "This is the Korean Flag", R.drawable.korean_flag),
            CountryModel(2, "Japan", "This is the Japan Flag", R.drawable.japan_flag),
            CountryModel(3, "New Zealand", "This is the New Zealand Flag", R.drawable.newzealand_flag),
            CountryModel(4, "USA", "This is the USA Flag", R.drawable.usa_flag),
            CountryModel(5, "France", "This is the France Flag", R.drawable.france_flag),
            CountryModel(6, "Germany", "This is the Germany Flag", R.drawable.germany_flag),
            CountryModel(7, "Philippine", "This is the Philippine Flag", R.drawable.philippine_flag),
            CountryModel(8, "Canada", "This is the Canada Flag", R.drawable.canada_flag),
            CountryModel(9, "DRC", "This is the DRC Flag", R.drawable.drc_flag),
        )
    }
    return countryList
}
