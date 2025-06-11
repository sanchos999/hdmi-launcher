@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.d("HDMITEST", "MainActivity стартовала — стартую сервис HdmiSwitcherService");
    startService(new Intent(this, HdmiSwitcherService.class));
    finish(); // сразу же закрываем Activity, чтобы не падать!
}
