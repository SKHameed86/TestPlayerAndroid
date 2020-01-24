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

        smp.loadFullScreen(PlayRequest.create(MediaContentVpid("m000dlqp", UserAgent(null), "mobile-phone-main"), MediaMetadata.MediaType.ONDEMAND, MediaMetadata.MediaAvType.VIDEO, avStatisticsProvider).build())
    }
}
