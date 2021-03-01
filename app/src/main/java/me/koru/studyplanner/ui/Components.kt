package me.koru.studyplanner.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.koru.studyplanner.LearningUnit
import java.time.LocalDate

@Composable
fun LearningUnitRow(unit: LearningUnit, modifier : Modifier = Modifier){
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = unit.text)


    }
}

@Composable
fun LearningUnitList(units: List<LearningUnit>){
    LazyColumn {
        items(units) {
            LearningUnitRow(unit = it)
        }
    }
}

@Preview
@Composable
fun PreviewLearningUnitRow(){
    LearningUnitRow(unit = LearningUnit(
        "",
        "test",
        LocalDate.now(),
        )
    )
}
