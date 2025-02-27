package com.pradip.shoppingcart.ui.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pradip.shoppingcart.R
import com.pradip.shoppingcart.data.entities.ProductEntity

@Composable
fun ProductItem(
    modifier: Modifier,
    productEntity: ProductEntity
){
    Box(
        modifier = modifier.fillMaxSize().padding(horizontal = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically) {
            Image(modifier = Modifier.size(150.dp), imageVector = ImageVector.vectorResource(R.drawable.ic_launcher_foreground), contentScale = "")
            Column {
                Text(modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp), text = productEntity.product_title, color = Color.Black)
                Column(modifier = Modifier.fillMaxWidth())  {
                    Text(modifier = Modifier.padding(6.dp).align(Alignment.Start), text = "Required Qty", fontSize = 16, color = Color.Gray)
                    Box(modifier = Modifier.padding(horizontal = 6.dp).align(Alignment.Start).background(
                        Color.Gray
                    )) {
                        Text(text = productEntity.required_qty, fontSize = 16, color = Color.Black)

                    }                }
                Column {
                    Text(modifier = Modifier.padding(6.dp).align(Alignment.Start), text = "Pickup Qty", fontSize = 16, color = Color.Gray)
                    Box(modifier = Modifier.padding(horizontal = 6.dp).align(Alignment.Start).background(
                        Color.Gray
                    )) {
                        Text(modifier = Modifier.fillMaxWidth(), text = productEntity.pickup_qty, fontSize = 16, color = Color.Black)

                    }

                }
            }
        }

    }


}

@Preview
@Composable
fun PreviewProductItem(){
    ProductItem(
        modifier = Modifier.fillMaxSize(),
        productEntity = ProductEntity(product_image = "", product_title = "onions", required_qty = 12, pickup_qty = 5)
    )
}