package gamers.code.digitalcupboard.data.model

import android.graphics.drawable.Drawable
import kotlin.Comparable
data class CategoriesModel(

    var primaryKey: Int,
    var owner:String,
    var CategoryName: String,
    var max: Int,
    var current: Int,

):Comparable<CategoriesModel> {
    var image: Drawable? = null
    var items: Item? = null
    var test: Drawable?=null
    override fun toString(): String {
        return "CatagoriesModel(primaryKey=$primaryKey, CategoryName='$CategoryName', max=$max, current=$current, image=$image)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CategoriesModel

        if (primaryKey != other.primaryKey) return false
        if (owner != other.owner) return false
        if (CategoryName != other.CategoryName) return false
        if (max != other.max) return false
        if (current != other.current) return false
        if (image != other.image) return false

        return true
    }

    override fun hashCode(): Int {
        var result = primaryKey
        result = 31 * result + owner.hashCode()
        result = 31 * result + CategoryName.hashCode()
        result = 31 * result + max
        result = 31 * result + current
        result = 31 * result + (image?.hashCode() ?: 0)
        return result
    }

    override fun compareTo(other: CategoriesModel): Int {
        if(CategoryName > other.CategoryName) return 1
        if(CategoryName < other.CategoryName) return -1

        return 0
    }


}
