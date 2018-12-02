package net.comorevi.cpapp.serverinfo;

import cn.nukkit.utils.Config;
import net.comorevi.cphone.cphone.CPhone;
import net.comorevi.cphone.cphone.application.ApplicationManifest;
import net.comorevi.cphone.cphone.model.Bundle;
import net.comorevi.cphone.cphone.model.Response;
import net.comorevi.cphone.cphone.widget.activity.ReturnType;
import net.comorevi.cphone.cphone.widget.activity.base.ModalActivity;
import net.comorevi.cphone.presenter.SharingData;

import cn.nukkit.utils.TextFormat;

import java.io.File;
import java.util.LinkedHashMap;

public class MainActivity extends ModalActivity {

    private String content;
    private Bundle bundle;
    private CPhone cPhone;

    public MainActivity(ApplicationManifest manifest) {
        super(manifest);
        File file = new File(SharingData.server.getDataPath() + "plugins/CPhone/AppData/CoSSeInfo");
        file.mkdirs();

        Config config = new Config(
                new File(file, "config.yml"),
                Config.YAML,
                new LinkedHashMap<String, Object>() {
                    {
                        put("Content", "これはサーバーの情報を表示するアプリです。");
                    }
                });
        config.save();

        this.content = config.getString("Content");
    }

    @Override
    public void onCreate(Bundle bundle) {
        this.setTitle(bundle.getString("mainactivity_title"));
        this.setContent(TextFormat.BOLD + "message: \n" + TextFormat.RESET + this.content);
        this.setButton1Text(bundle.getString("mainactivity_button1"));
        this.setButton2Text("");
        this.bundle = bundle;
        this.cPhone = bundle.getCPhone();
    }

    @Override
    public ReturnType onStop(Response response) {
        //ModalResponse modalResponse = (ModalResponse) response;

        return ReturnType.TYPE_END;
    }
}
