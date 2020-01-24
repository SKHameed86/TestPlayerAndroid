package uk.co.bbc.testplayerandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uk.co.bbc.httpclient.useragent.UserAgent
import uk.co.bbc.smpan.SMPBuilder
import uk.co.bbc.smpan.media.PlayRequest
import uk.co.bbc.smpan.media.model.MediaContentVpid
import uk.co.bbc.smpan.media.model.MediaMetadata
import uk.co.bbc.smpan.stats.ui.UserInteractionStatisticsProvider

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val avStatisticsProvider = DummyAVStatsProvider()
        val smp = SMPBuilder.create(applicationContext, "TestPlayer", "Android", UserInteractionStatisticsProvider.NULL).build()
        val mediaContentVpid = MediaContentVpid("m000dly5", UserAgent("a", "b"), "mobile-phone-main")

        smp.loadFullScreen(PlayRequest.create(mediaContentVpid, MediaMetadata.MediaType.ONDEMAND, MediaMetadata.MediaAvType.VIDEO, avStatisticsProvider).withAutoplay(true).build())
    }
}
