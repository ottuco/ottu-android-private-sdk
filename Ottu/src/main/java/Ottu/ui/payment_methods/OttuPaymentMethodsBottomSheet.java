package Ottu.ui.payment_methods;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.ChangeBounds;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;

import java.util.ArrayList;
import java.util.List;

import Ottu.R;
import Ottu.databinding.DialogPaymentMethodsBinding;
import Ottu.model.fetchTxnDetail.PaymentMethod;
import Ottu.util.BaseBottomSheetDialogFragment;
import Ottu.util.SwipeToDeleteCallback;

public class OttuPaymentMethodsBottomSheet extends BaseBottomSheetDialogFragment {

    private final OnPaymentClickListener listener;
    private DialogPaymentMethodsBinding binding;

    public static void show(FragmentManager fragmentManager, OnPaymentClickListener listener) {
        OttuPaymentMethodsBottomSheet dialog = new OttuPaymentMethodsBottomSheet(listener);

        dialog.show(fragmentManager, OttuPaymentMethodsBottomSheet.class.getSimpleName());
    }

    private OttuPaymentMethodsBottomSheet(OnPaymentClickListener listener) {
        this.listener = listener;
    }

    @Override
    public int getTheme() {
        return R.style.Ottu_BottomSheetDialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogPaymentMethodsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupViews();
    }

    private void setupViews() {
        PaymentMethodsAdapter adapter = new PaymentMethodsAdapter(createPaymentMethods(), method -> {
            listener.onPaymentClicked(method);
            dismiss();
        });
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwipeToDeleteCallback(requireContext(), adapter));

        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeRemoved(int positionStart, int itemCount) {
                super.onItemRangeRemoved(positionStart, itemCount);
                beginDelayedTransition();
            }
        });

        itemTouchHelper.attachToRecyclerView(binding.rvPaymentMethods);
        binding.rvPaymentMethods.setAdapter(adapter);
    }

    private List<PaymentMethod> createPaymentMethods() {
        ArrayList<PaymentMethod> data = new ArrayList<>();

        data.add(createPaymentMethod("Google Pay", "1"));
        data.add(createPaymentMethod("STC Pay", "2"));
        data.add(createPaymentMethod("STC Pay", "3"));
        data.add(createPaymentMethod("Credit Card", "4"));
        data.add(createPaymentMethod("KNET", "5"));
        data.add(createPaymentMethod("Benefit Pay", "6"));
        data.add(createPaymentMethod("Ottu PG", "7"));

        return data;
    }

    private PaymentMethod createPaymentMethod(String name, String type) {
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.name = name;
        paymentMethod.type = type;

        if (type.equals("3") || type.equals("4")) {
            paymentMethod.desc = "*8282 | Expires on 01/39";
            paymentMethod.cardNumber = "****8282";
            paymentMethod.cvv = true;
        }

        return paymentMethod;
    }

    private void beginDelayedTransition() {
        ViewGroup parent = (ViewGroup) binding.getRoot().getParent();

        final Transition transition = new ChangeBounds();
        transition.setDuration(300);

        TransitionManager.beginDelayedTransition(parent, transition);
    }

}
