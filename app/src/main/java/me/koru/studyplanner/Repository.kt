package me.koru.studyplanner

import com.squareup.sqldelight.Query
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*

class Repository(database: Database) {

    private val learningUnitQueries = database.learningUnitQueries
    private val recordQueries = database.recordQueries



    fun getLearningUnits() : Flow<List<LearningUnit>> {
        return learningUnitQueries.selectAll(mapper = { id: String, text: String, nextReview: Long? ->
            LearningUnit(id, text,
                nextReview?.let { LocalDate.ofEpochDay(it) })
        }).asFlow().mapToList()
    }

    fun addLearningUnit(text: String){
        learningUnitQueries.insert(
            id = UUID.randomUUID().toString(),
            text = text,
            nextReview = null
        )
    }

    fun updateLearningUnit(learningUnit: LearningUnit){
        learningUnitQueries.update(
            id = learningUnit.id,
            text = learningUnit.text,
            nextReview = learningUnit.nextReview?.toEpochDay() // x means "x day from 1970-01-01"
        )
    }

    fun deleteLearningUnit(id: ID) {
        learningUnitQueries.delete(id)
    }

    fun getRecordsByUnitId(unitId: ID) : Flow<List<Record>>{
        return recordQueries.selectByUnitId(unitId, mapper = { id: String, _, recordDate: Long, familiarity: Long?, note: String? ->
            Record(id, unitId, LocalDateTime.ofEpochSecond(recordDate,0, ZoneOffset.UTC), 0, note)
        } //TODO: to be edited
        ).asFlow().mapToList()
    }

}