package com.ssafy.ui.encyclopedia

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ssafy.ui.component.ErrorScreen
import com.ssafy.ui.component.LoadingScreen
import com.ssafy.ui.component.PlantCard
import com.ssafy.ui.component.PlantInfo
import com.ssafy.ui.component.TopBar
import com.ssafy.ui.theme.GrayColor
import com.ssafy.ui.theme.LightBackgroundColor
import com.ssafy.ui.theme.PrimaryColor
import com.ssafy.ui.theme.customTypography

val chipLabels = listOf("전체", "수집완료", "미발견")

@Composable
fun EncycScreenContent(
    modifier: Modifier = Modifier,
    encycScreenState: EncycScreenState,
    onIntent: (EncycUserIntent) -> Unit = {},
) {
    Scaffold(
        topBar = {
            TopBar("도감", onPop = { onIntent(EncycUserIntent.OnPop) })
        },
        content = { paddingValues ->
            when (encycScreenState) {
                is EncycScreenState.Loading -> {
                    LoadingScreen(modifier = modifier.padding(paddingValues))
                }

                is EncycScreenState.Loaded -> {
                    EncycScreenLoaded(
                        modifier = modifier.padding(paddingValues),
                        state = encycScreenState,
                        onIntent = onIntent,
                    )
                }

                is EncycScreenState.Error -> {
                    ErrorScreen(
                        modifier = modifier.padding(paddingValues),
                        encycScreenState.message,
                    )
                }
            }
        },
    )
}

@Composable
fun EncycScreenLoaded(
    modifier: Modifier,
    state: EncycScreenState.Loaded,
    onIntent: (EncycUserIntent) -> Unit = {},
) {
    Column(
        modifier =
            modifier
                .fillMaxSize(),
    ) {
        CollectionProgress(progress = state.progress)
        FilterChips(
            selectedChipIndex = state.selectedChipIndex,
            onChipSelected = { index ->
                onIntent(EncycUserIntent.OnChipSelected(index))
            },
        )
        EncycGrid(
            items = state.items,
            modifier = Modifier.weight(1f),
            onItemClicked = { onIntent(EncycUserIntent.OnItemSelect(it)) },
        )
    }
}

@Composable
fun FilterChipComponent(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    FilterChip(
        selected = isSelected,
        onClick = onClick,
        label = {
            Text(
                text = text,
                color = if (isSelected) LightBackgroundColor else Color.Black,
                fontWeight = FontWeight.Bold,
            )
        },
        enabled = true,
        shape = RoundedCornerShape(16.dp),
        colors =
            FilterChipDefaults.filterChipColors(
                containerColor = if (isSelected) PrimaryColor else LightBackgroundColor,
                selectedContainerColor = PrimaryColor,
                labelColor = if (isSelected) LightBackgroundColor else Color.Black,
            ),
        border =
            if (!isSelected) {
                BorderStroke(1.dp, Color.Black)
            } else {
                null
            },
    )
}

@Composable
fun FilterChips(
    selectedChipIndex: Int,
    onChipSelected: (Int) -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .padding(top = 8.dp),
    ) {
        chipLabels.forEachIndexed { index, label ->
            FilterChipComponent(
                text = label,
                isSelected = index == selectedChipIndex,
                onClick = {
                    onChipSelected(index)
                },
            )
        }
    }
}

@Immutable
data class EncycGridState(
    val plantName: String,
    val plantImage: String?,
    val isDiscovered: Boolean,
)

@Composable
fun EncycGrid(
    items: List<EncycGridState>,
    modifier: Modifier = Modifier,
    onItemClicked: (Long) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(4.dp),
        modifier =
            modifier
                .fillMaxHeight()
                .heightIn(min = 200.dp),
    ) {
        itemsIndexed(items) { index, item ->
            PlantCard(
                PlantInfo(
                    plantName = item.plantName,
                    plantImage = item.plantImage,
                    isDiscovered = item.isDiscovered,
                ),
                onClick = { onItemClicked(index.toLong()) },
            )
        }
    }
}

@Composable
fun CollectionProgress(progress: Float) {
    Surface(shadowElevation = 8.dp) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier =
                Modifier
                    .fillMaxWidth(),
        ) {
            Text(
                text = "수집률",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                style = customTypography.titleMedium,
                modifier =
                    Modifier
                        .padding(start = 8.dp)
                        .padding(top = 8.dp),
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "$progress%",
                color = Color.Gray,
                modifier =
                    Modifier
                        .align(Alignment.End)
                        .padding(end = 8.dp),
            )

            LinearProgressIndicator(
                progress = { progress / 100 },
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .padding(horizontal = 8.dp)
                        .clip(RoundedCornerShape(4.dp)),
                color = PrimaryColor,
                trackColor = GrayColor,
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EncycScreenPreview() {
    EncycScreenContent(
        encycScreenState =
            EncycScreenState.Loaded(
                selectedChipIndex = 0,
                items =
                    List(8) { index ->
                        EncycGridState(
                            plantName = "식물 $index",
                            plantImage = null,
                            isDiscovered = index % 2 == 0,
                        )
                    },
                progress = 60.0f,
            ),
    )
}

@Preview(showBackground = true)
@Composable
fun CollectionProgressPreview() {
    CollectionProgress(60.0f)
}
