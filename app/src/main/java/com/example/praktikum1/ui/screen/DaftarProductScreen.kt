package com.example.praktikum1.ui.screen


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext


import com.example.praktikum1.R
import com.example.praktikum1.data.dummy.DummyData
import com.example.praktikum1.data.model.Category
import com.example.praktikum1.data.model.Product



// ===========================
// PRODUCT ITEM CARD
// ===========================

@Composable
fun ProductItemCard(
    product: Product,
    onClick: () -> Unit
){

    Card(

        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
                onClick()
            },


        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )

    ){

        Column(

            modifier = Modifier
                .padding(12.dp)

        ){


            val imageRes =
                if(product.img == "dummy_product")
                    R.drawable.dummy_product
                else
                    R.drawable.dummy_product



            Image(

                painter = painterResource(
                    id = imageRes
                ),

                contentDescription = product.name,


                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .clip(
                        RoundedCornerShape(8.dp)
                    ),


                contentScale = ContentScale.Crop

            )



            Spacer(
                modifier = Modifier.height(8.dp)
            )



            Text(

                text = product.category.name,

                style = MaterialTheme.typography.labelSmall,

                color = MaterialTheme.colorScheme.primary

            )



            Spacer(
                modifier = Modifier.height(8.dp)
            )



            Text(

                text = product.name,

                style = MaterialTheme.typography.titleMedium,

                fontWeight = FontWeight.Bold,

                maxLines = 1,

                overflow = TextOverflow.Ellipsis

            )



            Spacer(
                modifier = Modifier.height(4.dp)
            )



            Text(

                text = "Rp ${product.price}",

                style = MaterialTheme.typography.bodyMedium,

                color = MaterialTheme.colorScheme.primary

            )

        }

    }

}





// ===========================
// CATEGORY ITEM
// ===========================

@Composable
fun CategoryItem(

    category: Category,

    isSelected: Boolean,

    onClick: () -> Unit

){


    Card(

        modifier = Modifier
            .padding(4.dp)
            .clickable {
                onClick()
            },


        colors = CardDefaults.cardColors(

            containerColor =

                if(isSelected)

                    MaterialTheme.colorScheme.primary

                else

                    MaterialTheme.colorScheme.surface

        )

    ){


        Text(

            text = category.name,

            modifier = Modifier
                .padding(8.dp),


            color =

                if(isSelected)

                    MaterialTheme.colorScheme.onPrimary

                else

                    MaterialTheme.colorScheme.onSurface

        )


    }


}





// ===========================
// PREVIEW
// ===========================


@Preview(showBackground = true)
@Composable
fun PreviewProduct(){


    ProductItemCard(

        product = DummyData.products[0],

        onClick = {}

    )


}



@Preview(showBackground = true)
@Composable
fun PreviewCategory(){


    CategoryItem(

        category = DummyData.categories[0],

        isSelected = true,

        onClick = {}

    )


}





// ===========================
// DAFTAR PRODUK SCREEN
// ===========================

@Composable
fun DaftarProdukScreen(){


    val context = LocalContext.current



    val categories = DummyData.categories

    val products = DummyData.products



    val selectedCategoryId = remember {

        mutableStateOf<Int?>(null)

    }




    val filteredProducts =

        if(selectedCategoryId.value == null){

            products

        }else{

            products.filter {

                it.category.id == selectedCategoryId.value

            }

        }




    Column {



        // Kategori Horizontal

        LazyRow {



            items(categories){ category ->



                CategoryItem(

                    category = category,


                    isSelected =

                        selectedCategoryId.value == category.id,



                    onClick = {


                        selectedCategoryId.value =
                            category.id


                    }


                )


            }


        }





        // Produk Grid

        LazyVerticalGrid(

            columns = GridCells.Fixed(2)

        ){



            items(filteredProducts){ product ->



                ProductItemCard(


                    product = product,


                    onClick = {


                        Toast.makeText(

                            context,

                            "Clicked: ${product.name}",

                            Toast.LENGTH_SHORT

                        ).show()


                    }


                )


            }


        }


    }

}