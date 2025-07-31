package ru.resodostudio.flick.core.designsystem.icon.filled

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ru.resodostudio.flick.core.designsystem.icon.FlickIcons

val FlickIcons.Filled.Theaters: ImageVector
    get() {
        if (_Theaters != null) {
            return _Theaters!!
        }
        _Theaters = ImageVector.Builder(
            name = "Filled.Theaters",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(240f, 760f)
                lineTo(240f, 800f)
                quadTo(240f, 817f, 228.5f, 828.5f)
                quadTo(217f, 840f, 200f, 840f)
                quadTo(183f, 840f, 171.5f, 828.5f)
                quadTo(160f, 817f, 160f, 800f)
                lineTo(160f, 160f)
                quadTo(160f, 143f, 171.5f, 131.5f)
                quadTo(183f, 120f, 200f, 120f)
                quadTo(217f, 120f, 228.5f, 131.5f)
                quadTo(240f, 143f, 240f, 160f)
                lineTo(240f, 200f)
                lineTo(320f, 200f)
                lineTo(320f, 160f)
                quadTo(320f, 143f, 331.5f, 131.5f)
                quadTo(343f, 120f, 360f, 120f)
                lineTo(600f, 120f)
                quadTo(617f, 120f, 628.5f, 131.5f)
                quadTo(640f, 143f, 640f, 160f)
                lineTo(640f, 200f)
                lineTo(720f, 200f)
                lineTo(720f, 160f)
                quadTo(720f, 143f, 731.5f, 131.5f)
                quadTo(743f, 120f, 760f, 120f)
                quadTo(777f, 120f, 788.5f, 131.5f)
                quadTo(800f, 143f, 800f, 160f)
                lineTo(800f, 800f)
                quadTo(800f, 817f, 788.5f, 828.5f)
                quadTo(777f, 840f, 760f, 840f)
                quadTo(743f, 840f, 731.5f, 828.5f)
                quadTo(720f, 817f, 720f, 800f)
                lineTo(720f, 760f)
                lineTo(640f, 760f)
                lineTo(640f, 800f)
                quadTo(640f, 817f, 628.5f, 828.5f)
                quadTo(617f, 840f, 600f, 840f)
                lineTo(360f, 840f)
                quadTo(343f, 840f, 331.5f, 828.5f)
                quadTo(320f, 817f, 320f, 800f)
                lineTo(320f, 760f)
                lineTo(240f, 760f)
                close()
                moveTo(240f, 680f)
                lineTo(320f, 680f)
                lineTo(320f, 600f)
                lineTo(240f, 600f)
                lineTo(240f, 680f)
                close()
                moveTo(240f, 520f)
                lineTo(320f, 520f)
                lineTo(320f, 440f)
                lineTo(240f, 440f)
                lineTo(240f, 520f)
                close()
                moveTo(240f, 360f)
                lineTo(320f, 360f)
                lineTo(320f, 280f)
                lineTo(240f, 280f)
                lineTo(240f, 360f)
                close()
                moveTo(640f, 680f)
                lineTo(720f, 680f)
                lineTo(720f, 600f)
                lineTo(640f, 600f)
                lineTo(640f, 680f)
                close()
                moveTo(640f, 520f)
                lineTo(720f, 520f)
                lineTo(720f, 440f)
                lineTo(640f, 440f)
                lineTo(640f, 520f)
                close()
                moveTo(640f, 360f)
                lineTo(720f, 360f)
                lineTo(720f, 280f)
                lineTo(640f, 280f)
                lineTo(640f, 360f)
                close()
            }
        }.build()

        return _Theaters!!
    }

@Suppress("ObjectPropertyName")
private var _Theaters: ImageVector? = null
