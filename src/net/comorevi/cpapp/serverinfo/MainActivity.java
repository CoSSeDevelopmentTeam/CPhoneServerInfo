package net.comorevi.cpapp.serverinfo;

import net.comorevi.cphone.cphone.CPhone;
import net.comorevi.cphone.cphone.application.ApplicationManifest;
import net.comorevi.cphone.cphone.model.Bundle;
import net.comorevi.cphone.cphone.model.ModalResponse;
import net.comorevi.cphone.cphone.model.Response;
import net.comorevi.cphone.cphone.widget.activity.ReturnType;
import net.comorevi.cphone.cphone.widget.activity.base.ModalActivity;

public class MainActivity extends ModalActivity {

    private CPhone cPhone;

    public MainActivity(ApplicationManifest manifest) {
        super(manifest);
    }

    @Override
    public void onCreate(Bundle bundle) {
        this.setTitle(bundle.getString("mainactivity_title"));
        this.setContent(bundle.getString("mainactivity_content"));
        this.setButton1Text(bundle.getString("mainactivity_button1"));
        this.setButton2Text("");
        this.cPhone = bundle.getCPhone();
    }

    @Override
    public ReturnType onStop(Response response) {
        //ModalResponse modalResponse = (ModalResponse) response;

        return ReturnType.TYPE_END;
    }
}
