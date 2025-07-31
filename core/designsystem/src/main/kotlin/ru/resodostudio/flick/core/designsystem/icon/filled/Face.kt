package ru.resodostudio.flick.core.designsystem.icon.filled

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ru.resodostudio.flick.core.designsystem.icon.FlickIcons

val FlickIcons.Filled.Face: ImageVector
    get() {
        if (_Face != null) {
            return _Face!!
        }
        _Face = ImageVector.Builder(
            name = "Filled.Face",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(360f, 570f)
                quadTo(339f, 570f, 324.5f, 555.5f)
                quadTo(310f, 541f, 310f, 520f)
                quadTo(310f, 499f, 324.5f, 484.5f)
                quadTo(339f, 470f, 360f, 470f)
                quadTo(381f, 470f, 395.5f, 484.5f)
                quadTo(410f, 499f, 410f, 520f)
                quadTo(410f, 541f, 395.5f, 555.5f)
                quadTo(381f, 570f, 360f, 570f)
                close()
                moveTo(600f, 570f)
                quadTo(579f, 570f, 564.5f, 555.5f)
                quadTo(550f, 541f, 550f, 520f)
                quadTo(550f, 499f, 564.5f, 484.5f)
                quadTo(579f, 470f, 600f, 470f)
                quadTo(621f, 470f, 635.5f, 484.5f)
                quadTo(650f, 499f, 650f, 520f)
                quadTo(650f, 541f, 635.5f, 555.5f)
                quadTo(621f, 570f, 600f, 570f)
                close()
                moveTo(480f, 800f)
                quadTo(614f, 800f, 707f, 707f)
                quadTo(800f, 614f, 800f, 480f)
                quadTo(800f, 456f, 797f, 433.5f)
                quadTo(794f, 411f, 786f, 390f)
                quadTo(765f, 395f, 744f, 397.5f)
                quadTo(723f, 400f, 700f, 400f)
                quadTo(609f, 400f, 528f, 361f)
                quadTo(447f, 322f, 390f, 252f)
                quadTo(358f, 330f, 298.5f, 387.5f)
                quadTo(239f, 445f, 160f, 474f)
                quadTo(160f, 476f, 160f, 477f)
                quadTo(160f, 478f, 160f, 480f)
                quadTo(160f, 614f, 253f, 707f)
                quadTo(346f, 800f, 480f, 800f)
                close()
                moveTo(480f, 880f)
                quadTo(397f, 880f, 324f, 848.5f)
                quadTo(251f, 817f, 197f, 763f)
                quadTo(143f, 709f, 111.5f, 636f)
                quadTo(80f, 563f, 80f, 480f)
                quadTo(80f, 397f, 111.5f, 324f)
                quadTo(143f, 251f, 197f, 197f)
                quadTo(251f, 143f, 324f, 111.5f)
                quadTo(397f, 80f, 480f, 80f)
                quadTo(563f, 80f, 636f, 111.5f)
                quadTo(709f, 143f, 763f, 197f)
                quadTo(817f, 251f, 848.5f, 324f)
                quadTo(880f, 397f, 880f, 480f)
                quadTo(880f, 563f, 848.5f, 636f)
                quadTo(817f, 709f, 763f, 763f)
                quadTo(709f, 817f, 636f, 848.5f)
                quadTo(563f, 880f, 480f, 880f)
                close()
            }
        }.build()

        return _Face!!
    }

@Suppress("ObjectPropertyName")
private var _Face: ImageVector? = null
