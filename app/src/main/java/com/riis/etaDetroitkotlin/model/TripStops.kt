package com.riis.etaDetroitkotlin.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.sql.Time

@Entity(
    primaryKeys = ["trip_id", "stop_id", "stop_sequence"],
    foreignKeys = [ForeignKey(
        entity = Trips::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("trip_id"),
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
    ),
        ForeignKey(
            entity = Stops::class,
            parentColumns = arrayOf("stop_id"),
            childColumns = arrayOf("stop_id"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ],
    tableName = "trip_stops"
)
data class TripStops(
    @ColumnInfo(name = "trip_id") val tripId: Int,
    @ColumnInfo(name = "stop_id") val stopId: Int,
    @ColumnInfo(name = "arrival_time") val arrivalTime: Time,
    @ColumnInfo(name = "stop_sequence") val stopSequence: Int
)
