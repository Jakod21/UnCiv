package com.unciv.logic.trade

import com.unciv.models.gamebasics.tr

data class TradeOffer(var name:String, var type: TradeType, var duration:Int, var amount:Int=1) {

    constructor() : this("", TradeType.Gold,0,0) // so that the json deserializer can work

    fun equals(offer: TradeOffer): Boolean {
        return offer.name==name
                && offer.type==type
                && offer.amount==amount
    }


    fun getOfferText(): String {
        var offerText = name.tr()
        if (type !in tradesToNotHaveNumbers) offerText += " (" + amount + ")"
        if (duration > 1) offerText += "\n" + duration + " {turns}".tr()
        return offerText
    }

    private companion object{
        val tradesToNotHaveNumbers = listOf(TradeType.Technology, TradeType.City,
            TradeType.Introduction, TradeType.Treaty, TradeType.WarDeclaration)
    }

}