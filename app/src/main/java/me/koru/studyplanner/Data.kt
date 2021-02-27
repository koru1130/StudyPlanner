package me.koru.studyplanner

import java.util.*

typealias ID = String

typealias Familiarity = Int

data class Record(val id: ID, val date: Date, val familiarity: Familiarity)

interface ILearningUnit {
    val id: ID
    val text: String
    val nextReview: Date
    val history: List<Record>
}