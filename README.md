# MVPTest
A simple mvp mode test.

##MVP mode(model view presenter):
mvp---》V--P--M--P--V
View:The role of the View layer is to define the interface of View,implements by the activity or fragment.(定义视图操作接口，由activity或者fragment来实现该接口)</br>
Presenter:The role of the Presenter layer is used as a brigde between View and Model which implements their controller. (P连接V与M，控制操作逻辑)</br>
Model:The role of the model is familiar with DAO,which in charge of data operation.(M则类似于数据库的操作类Dao，负责对具体数据操作)</br>

The structure of the demo(demo结构):
View:MainView(interface),MainActivity(implement)
Presenter:IMainPresenter(interface),MainPresenter(implement),Presenter(interface)
Model:MainModel(implement),MainModelBean(bean)
