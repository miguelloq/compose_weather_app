package com.example.weatherapp.presentation.components.region

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import com.example.weatherapp.domain.model.RegionModel
import com.example.weatherapp.presentation.state.RegionState

@Composable
fun PossibleRegionsList(regions:List<RegionModel>, modifier:Modifier = Modifier) {
    Column(modifier) {
        if(regions.isEmpty()){
            Text(
                modifier = Modifier.align(CenterHorizontally),
                text = "Search for a region")
        }else{
            Text(text = "Region 1")
            Text(text = "Region 2")
            Text(text = "Region 3")
            Text(text = "Region 4")
            Text(text = "Region 5")
            Text(text = "Region 6")
        }
    }
}