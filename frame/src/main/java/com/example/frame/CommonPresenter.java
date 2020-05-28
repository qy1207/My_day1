package com.example.frame;

public class CommonPresenter  implements ICommonPreserent{
    private CommonModel commonModel;
    private ICommonView iCommonView;

    public CommonPresenter(CommonModel commonModel, ICommonView iCommonView) {
        this.commonModel = commonModel;
        this.iCommonView = iCommonView;
    }




    @Override
    public void onSuccess(Object[] a) {
        iCommonView.onSuccess(a);
    }

    @Override
    public void onFailed(String str) {
        iCommonView.onFailed(str);
    }


    @Override
    public void getData(String p, String c) {
        commonModel.getData(p,c,this);
    }
}
