package com.zyrox.music.ui.player

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.zyrox.music.util.ZyroxHaptics
import com.zyrox.music.util.rememberZyroxHaptics

/**
 * Expressive haptics shared by every player style.
 *
 * Routes through [ZyroxHaptics], so everything here honours the user's haptics
 * setting along with the rest of the app.
 */
class PlayerHaptics(private val zyrox: ZyroxHaptics) {

    /** A previous/next skip committed (button tap or swipe gesture). */
    fun skip() = zyrox.confirm()

    /** Play/pause toggled; [nowPlaying] is the state being switched to. */
    fun playPause(nowPlaying: Boolean) = zyrox.toggle(nowPlaying)
}

@Composable
fun rememberPlayerHaptics(): PlayerHaptics {
    val zyrox = rememberZyroxHaptics()
    return remember(zyrox) { PlayerHaptics(zyrox) }
}
