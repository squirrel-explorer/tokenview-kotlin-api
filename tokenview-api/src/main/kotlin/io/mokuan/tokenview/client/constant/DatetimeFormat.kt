/**
 * Constant definitions for Datetime format
 *
 * @copyright       Copyright 2022 - 2023, mokuan.io
 * @license         MIT
 */

package io.mokuan.tokenview.client.constant

enum class DatetimeFormat(val format: String) {
    DATETIME_FORMAT_1("yyyy-MM-dd"),                    // eg: 2020-10-15
    DATETIME_FORMAT_2("yyyy-MM-dd HH:mm"),              // eg: 2020-10-15 08:30
    DATETIME_FORMAT_3("yyyy-MM-dd HH:mm:ss"),           // eg: 2020-10-15 08:30:00
    DATETIME_FORMAT_4("yyyy-MM-dd HH:mm:ss:S"),         // eg: 2020-10-15 08:30:00:080
    DATETIME_FORMAT_5("yyyy-MM-dd HH:mm:ss:S E zZ"),    // eg: 2020-10-15 08:30:00:080 Thu CST+0800
    DATETIME_FORMAT_6("yyyyMMddHHmmssS"),               // eg: 20201015083000080
    DATETIME_FORMAT_7("yyyy-MM-dd'T'HH:mm:ss.S'Z'"),    // eg: 2020-10-15T08:30:00:080Z
    DATETIME_FORMAT_8("yyyy年MM月dd日HH时mm分ss秒"),      // eg: 2020年10月15日08时30分00秒
    DATETIME_FORMAT_RAW("RAW"),
    ;
}