package com.example.superheroes

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.getUnclippedBoundsInRoot
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performScrollTo
import com.example.superheroes.ui.theme.SuperheroesTheme
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import kotlin.math.abs

/** Comprueba el recorrido real de la lista y la integración de los temas. */
class SuperheroesUiTest {
    @get:Rule
    val compose: ComposeContentTestRule = createComposeRule()

    private val expectedHeroes = listOf(
        "Nick the Night and Day" to "The Jetpack Hero",
        "Reality Protector" to "Understands the absolute truth",
        "Andre the Giant" to "Mimics the light and night to blend in",
        "Benjamin the Brave" to "Harnesses the power of canary to develop bravely",
        "Magnificent Maru" to "Effortlessly glides in to save the day",
        "Dynamic Yasmine" to "Ability to shift to any form and energize"
    )

    @Test
    fun modoClaroPermiteLeerLosSeisHeroesYDesplazarseAlFinal() {
        showAndCheckAllHeroes(dark = false)
    }

    @Test
    fun modoOscuroPermiteLeerLosSeisHeroesYDesplazarseAlFinal() {
        showAndCheckAllHeroes(dark = true)
    }

    private fun showAndCheckAllHeroes(dark: Boolean) {
        compose.setContent {
            SuperheroesTheme(darkTheme = dark) { SuperheroesApp() }
        }
        compose.onNodeWithText("Superheroes").assertIsDisplayed()
        expectedHeroes.forEach { (name, description) ->
            compose.onNodeWithText(name).performScrollTo().assertIsDisplayed()
            compose.onNodeWithText(description).performScrollTo().assertIsDisplayed()
        }
        // El título permanece visible al llegar a la última tarjeta.
        compose.onNodeWithText("Superheroes").assertIsDisplayed()
    }

    @Test
    fun tituloCentradoEnLaPantalla() {
        compose.setContent { SuperheroesTheme { SuperheroesApp() } }
        val title = compose.onNodeWithText("Superheroes").getUnclippedBoundsInRoot()
        val screen = compose.onRoot().getUnclippedBoundsInRoot()
        val titleCenter = (title.left.value + title.right.value) / 2f
        val screenCenter = (screen.left.value + screen.right.value) / 2f
        assertTrue(abs(titleCenter - screenCenter) <= 1f)
        compose.onNodeWithText(expectedHeroes.first().first).assertIsDisplayed()
    }

    @Test
    fun temaClaroUsaLaPaletaOficialSinColoresDinamicos() {
        checkPalette(dark = false, background = Color(0xFFFEFCF5), card = Color(0xFFE1E4D4))
    }

    @Test
    fun temaOscuroUsaLaPaletaOficialSinColoresDinamicos() {
        checkPalette(dark = true, background = Color(0xFF1B1C18), card = Color(0xFF45483D))
    }

    private fun checkPalette(dark: Boolean, background: Color, card: Color) {
        var actualBackground = Color.Unspecified
        var actualCard = Color.Unspecified
        compose.setContent {
            SuperheroesTheme(darkTheme = dark) {
                val colors = MaterialTheme.colorScheme
                SideEffect {
                    actualBackground = colors.background
                    actualCard = colors.surfaceVariant
                }
                SuperheroesApp()
            }
        }
        compose.runOnIdle {
            assertEquals(background, actualBackground)
            assertEquals(card, actualCard)
        }
    }
}
