public class DefaultFuncConfront implements Named34, Person32 {
    @Override
    public String getName() {
        return Named34.super.getName();
    }
}

interface Named34 {
    default String getName() {
        return getClass().getName() + "_" + hashCode();
    }
//    String getName();
}

interface Person32 {
//    default String getName() {
//        return getClass().getName() + "+" + hashCode();
//    }
    String getName();
}
