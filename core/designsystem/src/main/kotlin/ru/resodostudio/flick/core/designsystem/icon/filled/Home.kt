package ru.resodostudio.flick.core.designsystem.icon.filled

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ru.resodostudio.flick.core.designsystem.icon.FlickIcons

val FlickIcons.Filled.Home: ImageVector
    get() {
        if (_Home != null) {
            return _Home!!
        }
        _Home = ImageVector.Builder(
            name = "Filled.Home",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(160f, 760f)
                lineTo(160f, 400f)
                quadTo(160f, 381f, 168.5f, 364f)
                quadTo(177f, 347f, 192f, 336f)
                lineTo(432f, 156f)
                quadTo(453f, 140f, 480f, 140f)
                quadTo(507f, 140f, 528f, 156f)
                lineTo(768f, 336f)
                quadTo(783f, 347f, 791.5f, 364f)
                quadTo(800f, 381f, 800f, 400f)
                lineTo(800f, 760f)
                quadTo(800f, 793f, 776.5f, 816.5f)
                quadTo(753f, 840f, 720f, 840f)
                lineTo(600f, 840f)
                quadTo(583f, 840f, 571.5f, 828.5f)
                quadTo(560f, 817f, 560f, 800f)
                lineTo(560f, 600f)
                quadTo(560f, 583f, 548.5f, 571.5f)
                quadTo(537f, 560f, 520f, 560f)
                lineTo(440f, 560f)
                quadTo(423f, 560f, 411.5f, 571.5f)
                quadTo(400f, 583f, 400f, 600f)
                lineTo(400f, 800f)
                quadTo(400f, 817f, 388.5f, 828.5f)
                quadTo(377f, 840f, 360f, 840f)
                lineTo(240f, 840f)
                quadTo(207f, 840f, 183.5f, 816.5f)
                quadTo(160f, 793f, 160f, 760f)
                close()
            }
        }.build()

        return _Home!!
    }

@Suppress("ObjectPropertyName")
private var _Home: ImageVector? = null
