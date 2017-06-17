package com.adviser.campaign.model

import android.util.Log

/**
 * Created by Kairos on 2017. 6. 11..
 */
class CampaignInfoManager {

  private var agent = HttpRequestAgent()
  private var locationId: String = ""
  private var list = arrayListOf<CampaignInfo>()
  private var cur: Int = 0

  fun loadCampaign(locationId: String) {
    Log.d("clog/CampaignInfoManager", "loadCampaign Start")
    this.locationId = locationId
    this.list = agent.getCampaignList(locationId)
    Log.d("clog/CampaignInfoManager", "loadCampaign Complete")
  }

  fun getNextCampaign(): CampaignInfo? {
    val ci: CampaignInfo? = list[cur++]
    Log.d("clog/CampaignList", "getNext: $ci")
    return ci
  }

  fun getCampaign(idx: Int): CampaignInfo {
    //TODO("array out of bounds Exception")
    return list[idx]
  }

  fun getCampaignCount(): Int {
    return list.size
  }

}