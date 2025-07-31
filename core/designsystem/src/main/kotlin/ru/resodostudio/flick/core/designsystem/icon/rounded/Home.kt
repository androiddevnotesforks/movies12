package ru.resodostudio.flick.core.designsystem.icon.rounded

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ru.resodostudio.flick.core.designsystem.icon.FlickIcons

val FlickIcons.Rounded.Home: ImageVector
    get() {
        if (_Home != null) {
            return _Home!!
        }
        _Home = ImageVector.Builder(
            name = "Rounded.Home",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(240f, 760f)
                lineTo(360f, 760f)
                lineTo(360f, 560f)
                quadTo(360f, 543f, 371.5f, 531.5f)
                quadTo(383f, 520f, 400f, 520f)
                lineTo(560f, 520f)
                quadTo(577f, 520f, 588.5f, 531.5f)
                quadTo(600f, 543f, 600f, 560f)
                lineTo(600f, 760f)
                lineTo(720f, 760f)
                lineTo(720f, 400f)
                quadTo(720f, 400f, 720f, 400f)
                quadTo(720f, 400f, 720f, 400f)
                lineTo(480f, 220f)
                quadTo(480f, 220f, 480f, 220f)
                quadTo(480f, 220f, 480f, 220f)
                lineTo(240f, 400f)
                quadTo(240f, 400f, 240f, 400f)
                quadTo(240f, 400f, 240f, 400f)
                lineTo(240f, 760f)
                close()
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
                lineTo(560f, 840f)
                quadTo(543f, 840f, 531.5f, 828.5f)
                quadTo(520f, 817f, 520f, 800f)
                lineTo(520f, 600f)
                quadTo(520f, 600f, 520f, 600f)
                quadTo(520f, 600f, 520f, 600f)
                lineTo(440f, 600f)
                quadTo(440f, 600f, 440f, 600f)
                quadTo(440f, 600f, 440f, 600f)
                lineTo(440f, 800f)
                quadTo(440f, 817f, 428.5f, 828.5f)
                quadTo(417f, 840f, 400f, 840f)
                lineTo(240f, 840f)
                quadTo(207f, 840f, 183.5f, 816.5f)
                quadTo(160f, 793f, 160f, 760f)
                close()
                moveTo(480f, 490f)
                lineTo(480f, 490f)
                lineTo(480f, 490f)
                quadTo(480f, 490f, 480f, 490f)
                quadTo(480f, 490f, 480f, 490f)
                lineTo(480f, 490f)
                lineTo(480f, 490f)
                lineTo(480f, 490f)
                lineTo(480f, 490f)
                quadTo(480f, 490f, 480f, 490f)
                quadTo(480f, 490f, 480f, 490f)
                lineTo(480f, 490f)
                quadTo(480f, 490f, 480f, 490f)
                quadTo(480f, 490f, 480f, 490f)
                lineTo(480f, 490f)
                close()
            }
        }.build()

        return _Home!!
    }

@Suppress("ObjectPropertyName")
private var _Home: ImageVector? = null
