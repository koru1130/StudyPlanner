package me.koru.studyplanner

import kotlinx.coroutines.flow.Flow
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

typealias ID = String

typealias Familiarity = Int

data class Record(
    val id: ID,
    val unitId: ID,
    val date: LocalDateTime,
    val familiarity: Familiarity,
    val note: String?
    )

data class LearningUnit(
    val id: ID,
    val text: String,
    val nextReview: LocalDate?
)

fun LearningUnit.getHistory(repo : Repository): Flow<List<Record>> {
    return repo.getRecordsByUnitId(this.id)
}

fun LearningUnit.update(repo: Repository, text: String, nextReview: LocalDate?){
    repo.updateLearningUnit(
        LearningUnit(
        id = this.id,
        text = text,
        nextReview = nextReview
    ))
}

fun LearningUnit.delete(repo: Repository){
    repo.deleteLearningUnit(id = this.id)
}