package fuzitao.diswy.learn_comprehensive_demo.utils;

import com.google.gson.Gson;

import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

import fuzitao.diswy.learn_comprehensive_demo.ikidou.reflect.TypeBuilder;
import fuzitao.diswy.learn_comprehensive_demo.json.Result;

/**
 * 数据处理
 * Created by Fu.Zi.Tao on 2017/3/2 0002.
 */

public class DataUtils {

    public static <T> Result<List<T>> fromJsonArray(Reader reader, Class<T> clazz) {
        Gson gson = new Gson();
        Type type = TypeBuilder
                .newInstance(Result.class)
                .beginSubType(List.class)
                .addTypeParam(clazz)
                .endSubType()
                .build();
        return gson.fromJson(reader, type);
    }

    public static <T> Result<T> fromJsonObject(Reader reader, Class<T> clazz) {
        Gson gson = new Gson();
        Type type = TypeBuilder
                .newInstance(Result.class)
                .addTypeParam(clazz)
                .build();
        return gson.fromJson(reader, type);
    }
}
