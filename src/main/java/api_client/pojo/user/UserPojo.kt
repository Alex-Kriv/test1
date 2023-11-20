package api_client.pojo.user

import com.google.gson.annotations.SerializedName

open class UserPojo {
    data class UserPojoRes(
        @SerializedName("name") var name: String? = null,
        @SerializedName("phone") var phone: String? = null,
        @SerializedName("session") var session: String? = null,
        @SerializedName("phoneStatus") var phoneStatus: String? = null,
        @SerializedName("addresses") var addresses: ArrayList<Addresses> = arrayListOf(),
        @SerializedName("order") var order: Any? = null,
        @SerializedName("wallet") var wallet: ArrayList<String> = arrayListOf(),
        @SerializedName("bonuses") var bonuses: Int? = null,
        @SerializedName("instagram") var instagram: String? = null,
        @SerializedName("email") var email: String? = null,
        @SerializedName("birthDate") var birthDate: String? = null,
        @SerializedName("bonusCardCode") var bonusCardCode: String? = null,
        @SerializedName("bonusProgram") var bonusProgram: String? = null
    )


    data class Addresses(

        @SerializedName("code") var code: Int? = null,
        @SerializedName("street") var street: String? = null,
        @SerializedName("flat") var flat: String? = null,
        @SerializedName("floor") var floor: String? = null,
        @SerializedName("entrance") var entrance: String? = null,
        @SerializedName("doorphone") var doorphone: String? = null,
        @SerializedName("comment") var comment: String? = null,
        @SerializedName("longitude") var longitude: Double? = null,
        @SerializedName("latitude") var latitude: Double? = null,
        @SerializedName("city") var city: String? = null,
        @SerializedName("shopId") var shopId: String? = null,
        @SerializedName("zoneId") var zoneId: String? = null,
        @SerializedName("yandex") var yandex: Yandex? = Yandex()
    )

    data class Yandex(

        @SerializedName("GeoObject") var GeoObject: GeoObject? = GeoObject()

    )

    data class GeoObject(

        @SerializedName("uri") var uri: String? = null,
        @SerializedName("name") var name: String? = null,
        @SerializedName("Point") var Point: Point? = Point(),
        @SerializedName("boundedBy") var boundedBy: BoundedBy? = BoundedBy(),
        @SerializedName("description") var description: String? = null,
        @SerializedName("metaDataProperty") var metaDataProperty: MetaDataProperty? = MetaDataProperty()

    )

    data class Point(

        @SerializedName("pos") var pos: String? = null

    )

    data class BoundedBy(

        @SerializedName("Envelope") var Envelope: Envelope? = Envelope()

    )

    data class MetaDataProperty(

        @SerializedName("GeocoderMetaData") var GeocoderMetaData: GeocoderMetaData? = GeocoderMetaData()

    )

    data class Envelope(

        @SerializedName("lowerCorner") var lowerCorner: String? = null,
        @SerializedName("upperCorner") var upperCorner: String? = null

    )

    data class GeocoderMetaData(

        @SerializedName("kind") var kind: String? = null,
        @SerializedName("text") var text: String? = null,
        @SerializedName("Address") var Address: Address? = Address(),
        @SerializedName("precision") var precision: String? = null,
        @SerializedName("AddressDetails") var AddressDetails: AddressDetails? = AddressDetails()

    )

    data class Address(

        @SerializedName("formatted") var formatted: String? = null,
        @SerializedName("Components") var Components: ArrayList<Components> = arrayListOf(),
        @SerializedName("postal_code") var postalCode: String? = null,
        @SerializedName("country_code") var countryCode: String? = null

    )
    data class Components(

        @SerializedName("kind") var kind: String? = null,
        @SerializedName("name") var name: String? = null

    )

    data class AddressDetails(

        @SerializedName("Country") var Country: Country? = Country()

    )




    data class Country(

        @SerializedName("AddressLine") var AddressLine: String? = null,
        @SerializedName("CountryName") var CountryName: String? = null,
        @SerializedName("CountryNameCode") var CountryNameCode: String? = null,
        @SerializedName("AdministrativeArea") var AdministrativeArea: AdministrativeArea? = AdministrativeArea()

    )

    data class AdministrativeArea(

        @SerializedName("Locality") var Locality: Locality? = Locality(),
        @SerializedName("AdministrativeAreaName") var AdministrativeAreaName: String? = null

    )

    data class Locality(

        @SerializedName("LocalityName") var LocalityName: String? = null,
        @SerializedName("Thoroughfare") var Thoroughfare: Thoroughfare? = Thoroughfare()

    )

    data class Thoroughfare(

        @SerializedName("Premise") var Premise: Premise? = Premise(),
        @SerializedName("ThoroughfareName") var ThoroughfareName: String? = null

    )

    data class Premise(

        @SerializedName("PostalCode") var PostalCode: PostalCode? = PostalCode(),
        @SerializedName("PremiseNumber") var PremiseNumber: String? = null

    )

    data class PostalCode(

        @SerializedName("PostalCodeNumber") var PostalCodeNumber: String? = null

    )


}