package com.d.campaign.model

/**
 * Created by Kairos on 2017. 6. 1..
 */

class CampaignInfo: Comparable<CampaignInfo> {
  val id: String
  val order: Int
  val title: String
  val url: String // 이미지 url
  val adExpireDay: Int
  val template: Int //템플릿 변수

  constructor(id: String, order:Int, title: String, url: String, adExpireDay: Int, template: Int) {
    this.id = id
    this.order = order
    this.title = title
    this.url = url
    this.adExpireDay = adExpireDay
    this.template = template
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other?.javaClass != javaClass) return false

    other as CampaignInfo

    if (id != other.id) return false
    if (order != other.order) return false
    if (title != other.title) return false
    if (url != other.url) return false
    if (adExpireDay != other.adExpireDay) return false
    if (template != other.template) return false

    return true
  }

  override fun hashCode(): Int {
    var result = id.hashCode()
    result = 31 * result + order
    result = 31 * result + title.hashCode()
    result = 31 * result + url.hashCode()
    result = 31 * result + adExpireDay
    result = 31 * result + template
    return result
  }

  override fun toString(): String {
    return "CampaignInfo(id='$id', order=$order, title='$title', url='$url', adExpireDay=$adExpireDay, template=$template)"
  }

  override fun compareTo(other: CampaignInfo): Int
    = compareValuesBy(this, other, { it. order })
}