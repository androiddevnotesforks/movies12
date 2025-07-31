package ru.resodostudio.flick.core.designsystem.icon.rounded

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ru.resodostudio.flick.core.designsystem.icon.FlickIcons

val FlickIcons.Rounded.LiveTv: ImageVector
    get() {
        if (_LiveTv != null) {
            return _LiveTv!!
        }
        _LiveTv = ImageVector.Builder(
            name = "Rounded.LiveTv",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(442f, 580f)
                lineTo(608f, 474f)
                quadTo(626f, 462f, 626f, 440f)
                quadTo(626f, 418f, 608f, 406f)
                lineTo(442f, 300f)
                quadTo(422f, 287f, 401f, 298f)
                quadTo(380f, 309f, 380f, 333f)
                lineTo(380f, 547f)
                quadTo(380f, 571f, 401f, 582f)
                quadTo(422f, 593f, 442f, 580f)
                close()
                moveTo(160f, 760f)
                quadTo(127f, 760f, 103.5f, 736.5f)
                quadTo(80f, 713f, 80f, 680f)
                lineTo(80f, 200f)
                quadTo(80f, 167f, 103.5f, 143.5f)
                quadTo(127f, 120f, 160f, 120f)
                lineTo(800f, 120f)
                quadTo(833f, 120f, 856.5f, 143.5f)
                quadTo(880f, 167f, 880f, 200f)
                lineTo(880f, 680f)
                quadTo(880f, 713f, 856.5f, 736.5f)
                quadTo(833f, 760f, 800f, 760f)
                lineTo(640f, 760f)
                lineTo(640f, 800f)
                quadTo(640f, 817f, 628.5f, 828.5f)
                quadTo(617f, 840f, 600f, 840f)
                lineTo(360f, 840f)
                quadTo(343f, 840f, 331.5f, 828.5f)
                quadTo(320f, 817f, 320f, 800f)
                lineTo(320f, 760f)
                lineTo(160f, 760f)
                close()
                moveTo(160f, 680f)
                lineTo(800f, 680f)
                quadTo(800f, 680f, 800f, 680f)
                quadTo(800f, 680f, 800f, 680f)
                lineTo(800f, 200f)
                quadTo(800f, 200f, 800f, 200f)
                quadTo(800f, 200f, 800f, 200f)
                lineTo(160f, 200f)
                quadTo(160f, 200f, 160f, 200f)
                quadTo(160f, 200f, 160f, 200f)
                lineTo(160f, 680f)
                quadTo(160f, 680f, 160f, 680f)
                quadTo(160f, 680f, 160f, 680f)
                close()
                moveTo(160f, 680f)
                quadTo(160f, 680f, 160f, 680f)
                quadTo(160f, 680f, 160f, 680f)
                lineTo(160f, 200f)
                quadTo(160f, 200f, 160f, 200f)
                quadTo(160f, 200f, 160f, 200f)
                lineTo(160f, 200f)
                quadTo(160f, 200f, 160f, 200f)
                quadTo(160f, 200f, 160f, 200f)
                lineTo(160f, 680f)
                quadTo(160f, 680f, 160f, 680f)
                quadTo(160f, 680f, 160f, 680f)
                close()
            }
        }.build()

        return _LiveTv!!
    }

@Suppress("ObjectPropertyName")
private var _LiveTv: ImageVector? = null
