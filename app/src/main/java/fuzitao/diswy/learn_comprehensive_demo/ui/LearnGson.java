package fuzitao.diswy.learn_comprehensive_demo.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.Reader;
import java.io.StringReader;

import butterknife.Bind;
import butterknife.ButterKnife;
import fuzitao.diswy.learn_comprehensive_demo.R;
import fuzitao.diswy.learn_comprehensive_demo.json.Man;
import fuzitao.diswy.learn_comprehensive_demo.json.Result;
import fuzitao.diswy.learn_comprehensive_demo.utils.DataUtils;

public class LearnGson extends BaseActivity {

    @Bind(R.id.json_obj_str)
    TextView jsonObjStr;
    @Bind(R.id.json_obj_description)
    TextView jsonObjDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_gson);
        ButterKnife.bind(this);

        Man man = new Man();
        man.setAge(15);
        man.setName("小夫子");

        Gson gson = new Gson();
        String manToString = gson.toJson(man);

        Log.d("TAG", manToString);

        String s = "{\"code\":\"0\",\"message\":\"success\",\"data\":{\"name\":\"小夫子\",\"age\":15}}";
        Reader reader = new StringReader(s);
        Result<Man> sss = DataUtils.fromJsonObject(reader, Man.class);
        Log.d("TAG", sss.data.getAge() + "");
        Log.d("TAG", sss.data.getName());

        jsonObjStr.setText(manToString);
        jsonObjDescription.setText(sss.data.getName() + ":" + sss.data.getAge());


    }


}
