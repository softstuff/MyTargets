/*
 * Copyright (C) 2018 Florian Dreier
 *
 * This file is part of MyTargets.
 *
 * MyTargets is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2
 * as published by the Free Software Foundation.
 *
 * MyTargets is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

package de.dreier.mytargets.utils

import de.dreier.mytargets.shared.SharedApplicationInstance
import de.dreier.mytargets.shared.models.TimerSettings

object WearSettingsManager {
    private const val KEY_TIMER_ENABLED = "timer_enabled"
    private const val KEY_TIMER_WARN_TIME = "timer_warn_time"
    private const val KEY_TIMER_WAIT_TIME = "timer_wait_time"
    private const val KEY_TIMER_SHOOT_TIME = "timer_shoot_time"
    private const val KEY_TIMER_VIBRATE = "timer_vibrate"
    private const val KEY_TIMER_SOUND = "timer_sound"
    private val preferences = SharedApplicationInstance.sharedPreferences

    var timerSettings: TimerSettings
        get() {
            val settings = TimerSettings()
            settings.enabled = preferences.getBoolean(KEY_TIMER_ENABLED, false)
            settings.vibrate = preferences.getBoolean(KEY_TIMER_VIBRATE, false)
            settings.sound = preferences.getBoolean(KEY_TIMER_SOUND, true)
            settings.waitTime = preferences.getInt(KEY_TIMER_WAIT_TIME, 10)
            settings.shootTime = preferences.getInt(KEY_TIMER_SHOOT_TIME, 120)
            settings.warnTime = preferences.getInt(KEY_TIMER_WARN_TIME, 30)
            return settings
        }
        set(settings) = preferences
                .edit()
                .putBoolean(KEY_TIMER_ENABLED, settings.enabled)
                .putBoolean(KEY_TIMER_VIBRATE, settings.vibrate)
                .putBoolean(KEY_TIMER_SOUND, settings.sound)
                .putInt(KEY_TIMER_WAIT_TIME, settings.waitTime)
                .putInt(KEY_TIMER_SHOOT_TIME, settings.shootTime)
                .putInt(KEY_TIMER_WARN_TIME, settings.warnTime)
                .apply()
}
