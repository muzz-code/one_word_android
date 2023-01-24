package com.ebookfrenzy.one_word.util

import com.ebookfrenzy.one_word.R
import com.ebookfrenzy.one_word.data.model.*

object ResourceDummyData {
    /**this is the dummy data for the gallery page **/
    val galleryList = listOf(
        GalleryData(1, R.drawable.ocean_view),
        GalleryData(2, R.drawable.ocean_view),
        GalleryData(3, R.drawable.ocean_view),
        GalleryData(4, R.drawable.ocean_view),
        GalleryData(5, R.drawable.ocean_view)
    )

    val upcomingPrograms = listOf(
        ProgramData ("2023-01-14", "8:00AM", "1", "Sunday Service", R.drawable.ocean_view),
        ProgramData ("2023-01-14", "8:00AM", "1", "Anointing Service", R.drawable.ocean_view),
        ProgramData ("2023-01-14", "4:00PM", "1", "Wednesday Service", R.drawable.ocean_view),
        ProgramData ("2023-01-14", "8:00AM", "1", "Sunday Service", R.drawable.ocean_view)
    )

    /**
     * this is a sample dummy data for the stacking cards on homeFragment
     * */
    val cardViewDummyData = listOf(
        CardViewData( R.drawable.photo_male_1),
        CardViewData( R.drawable.photo_female_1),
        CardViewData( R.drawable.photo_female_2),
        CardViewData( R.drawable.photo_male_1),
        CardViewData( R.drawable.photo_male_2)
    )

    var videoItem = mutableListOf(
        ResourceGeneralVideoModel(

            "https://assets.mixkit.co/videos/preview/mixkit-woman-modelling-dress-in-a-studio-806-small.mp4",
            "How to perfectly sew headgear",
            R.drawable.one_word_logo
        ),
        ResourceGeneralVideoModel(
            "https://assets.mixkit.co/videos/preview/mixkit-woman-modelling-dress-in-a-studio-806-small.mp4",
            "How to perfectly sew adire",
            R.drawable.one_word_logo
        ),
        ResourceGeneralVideoModel(
            "https://assets.mixkit.co/videos/preview/mixkit-tailor-working-in-their-shop-11446-small.mp4",
            "Easy kaftan cutting and stitching",
            R.drawable.one_word_logo
        ),
        ResourceGeneralVideoModel(
            "https://assets.mixkit.co/videos/preview/mixkit-hands-of-a-tailor-sewing-a-dress-12522-small.mp4",
            "Personal styling",
            R.drawable.one_word_logo
        ),
        ResourceGeneralVideoModel(
            "https://assets.mixkit.co/videos/preview/mixkit-tailor-working-with-patterns-15120-small.mp4",
            "Gown cutting step by step",
            R.drawable.one_word_logo
        ),
        ResourceGeneralVideoModel(
            "https://assets.mixkit.co/videos/preview/mixkit-tailor-working-with-patterns-15120-small.mp4",
            "Off shoulder dress",
            R.drawable.one_word_logo
        )
    )
    var articleItem = mutableListOf(
        ResourceGeneralArticleModel(
            "https://i.pinimg.com/236x/84/21/22/84212218025a261761611acde7bcc750--modern-patterns-vintage-sewing-patterns.jpg",
            "Modern Pattern Design",
            "By Micheal Isesele"
        ),
        ResourceGeneralArticleModel(
            "https://images-na.ssl-images-amazon.com/images/I/71zkHiajWKL.jpg",
            "Tailoring",
            "By Nathan Maro"
        ),
        ResourceGeneralArticleModel(
            "https://d3re0f381bckq9.cloudfront.net/21704349_1538442884364_336x400.jpg",
            "Sewing Book",
            "By Nathan Maro"
        ),
        ResourceGeneralArticleModel(
            "https://cdn.exoticindia.com/images/products/original/books-2017/naj257.jpg",
            "Stitching Neatly",
            "By Nathan Maro"
        ),
        ResourceGeneralArticleModel(
            "https://www.google.com/imgres?imgurl=https%3A%2F%2Fd1w7fb2mkkr3kw.cloudfront.net%2Fassets%2Fimages%2Fbook%2Flrg%2F9781%2F6008%2F9781600853357.jpg&imgrefurl=https%3A%2F%2Fwww.bookdepository.com%2FCouture-Sewing-Techniques-Claire-B-Shaeffer%2F9781600853357&tbnid=QxNx15mBTejnrM&vet=10CBgQxiAoB2oXChMIyNz66fb48QIVAAAAAB0AAAAAEAg..i&docid=HrY8DBWVY-9VwM&w=344&h=430&itg=1&q=tailoring%20publication%20covers&ved=0CBgQxiAoB2oXChMIyNz66fb48QIVAAAAAB0AAAAAEAg",
            "Stitching Neatly",
            "By Nathan Maro"
        )
    )
    var videoViewAllItem = mutableListOf(
        ResourceDetailVideoModel(
            "https://assets.mixkit.co/videos/preview/mixkit-tailor-cutting-along-a-measuring-tape-11812-small.mp4",
            "How to perfectly sew headgear",
            "1 hour 24 mins",
            R.drawable.one_word_logo
        ),
        ResourceDetailVideoModel(
            "https://assets.mixkit.co/videos/preview/mixkit-woman-modelling-dress-in-a-studio-806-small.mp4",
            "How to perfectly sew adire",
            "1 hour 10 mins",
            R.drawable.one_word_logo
        ),
        ResourceDetailVideoModel(
            "https://assets.mixkit.co/videos/preview/mixkit-tailor-working-in-their-shop-11446-small.mp4",
            "Easy kaftan cutting and stitching",
            "30 mins",
            R.drawable.one_word_logo
        ),
        ResourceDetailVideoModel(
            "https://assets.mixkit.co/videos/preview/mixkit-hands-of-a-tailor-sewing-a-dress-12522-small.mp4",
            "Personal styling",
            "1 hour 14 mins",
            R.drawable.one_word_logo
        ),
        ResourceDetailVideoModel(
            "https://assets.mixkit.co/videos/preview/mixkit-tailor-working-with-patterns-15120-small.mp4",
            "Gown cutting step by step",
            "1 hour 24 mins",
            R.drawable.one_word_logo
        ),
        ResourceDetailVideoModel(
            "https://assets.mixkit.co/videos/preview/mixkit-tailor-working-with-patterns-15120-small.mp4",
            "Off shoulder dress",
            "24 mins",
            R.drawable.one_word_logo
        ),
        ResourceDetailVideoModel(
            "https://assets.mixkit.co/videos/preview/mixkit-tailor-pinning-lace-to-fabric-15110-small.mp4",
            "Curved hem sewing techniques for beginners",
            "1 hour 24 mins",
            R.drawable.one_word_logo
        ),
        ResourceDetailVideoModel(
            "https://assets.mixkit.co/videos/preview/mixkit-hands-of-a-tailor-working-12528-small.mp4",
            "How to perfectly sew attire",
            "1 hour",
            R.drawable.one_word_logo
        )
    )

    val settingsList = arrayListOf(
        SettingsItems(
            R.drawable.ic_lock, "Privacy Policy", R.drawable.ic_right_arrow,0
        ),
        SettingsItems(
            R.drawable.ic_baseline_send_24, "Share", R.drawable.ic_right_arrow,1
        )
    )
}
