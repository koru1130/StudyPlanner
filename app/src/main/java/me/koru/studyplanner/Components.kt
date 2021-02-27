package me.koru.studyplanner

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun LearningUnitRow(unit: ILearningUnit){
    Row() {
        Text(text = unit.text)
    }
}

@Composable
fun LearningUnitList(units: List<ILearningUnit>){
    LazyColumn() {
        items(units) {
            LearningUnitRow(unit = it)
        }
    }
}