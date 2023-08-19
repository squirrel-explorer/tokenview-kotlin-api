/**
 * Utils for Datetime handling
 *
 * @copyright       Copyright 2022 - 2023, mokuan.io
 * @license         MIT
 */

package io.mokuan.tokenview.client.utils

import io.mokuan.tokenview.client.constant.DatetimeFormat
import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    /**
     * The time string in specific format
     */
    fun timeToString(time: Date, format: DatetimeFormat): String {
        return when (format) {
            DatetimeFormat.DATETIME_FORMAT_1,
            DatetimeFormat.DATETIME_FORMAT_2,
            DatetimeFormat.DATETIME_FORMAT_3,
            DatetimeFormat.DATETIME_FORMAT_4,
            DatetimeFormat.DATETIME_FORMAT_5,
            DatetimeFormat.DATETIME_FORMAT_6,
            DatetimeFormat.DATETIME_FORMAT_7,
            DatetimeFormat.DATETIME_FORMAT_8 -> {
                SimpleDateFormat(format.format).format(time)
            }
            DatetimeFormat.DATETIME_FORMAT_RAW -> {
                time.toString()
            }
        }
    }

    /**
     * UNIX timestamp (ISO 8601)
     * eg: 2020-10-15T08:30:00.080Z
     */
    val simpleTime: String
        get() = Date(System.currentTimeMillis()).toInstant().toString()
}