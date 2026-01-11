package com.example.safezone.domain.logic

object RiskEngine {

    fun calculateRisk(
        authorityScore: Int,
        userFeedbackScore: Int,
        hourOfDay: Int
    ): Pair<Int, String> {

        val timeRisk = when {
            hourOfDay in 22..23 || hourOfDay in 0..4 -> 80
            hourOfDay in 18..21 -> 60
            else -> 30
        }

        val finalScore = (
                authorityScore * 0.5 +
                        userFeedbackScore * 0.3 +
                        timeRisk * 0.2
                ).toInt()

        val level = when {
            finalScore <= 30 -> "SAFE"
            finalScore <= 60 -> "CAUTION"
            else -> "DANGER"
        }

        return finalScore to level
    }
}
