package studio.ultoolapp.examplemvvm.viewmodel;

import studio.ultoolapp.examplemvvm.data.ExampleData;

/**
 * 一個簡單的View Model.
 * 參見： https://ithelp.ithome.com.tw/articles/10192829
 */
public class ExampleViewModel {
    private ExampleData exampleData = new ExampleData();

    public void refresh() {
        exampleData.retrieveData(new ExampleData.OnDataReadyCallback() {
            @Override
            public void onDataReady(String data) {
                // TODO: 2020/9/28 設定View的資訊
            }
        });
    }

}
