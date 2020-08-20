package com.stripe.model;

import com.google.gson.annotations.SerializedName;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.net.ApiResource;
import com.stripe.net.RequestOptions;
import com.stripe.param.InvoiceItemCreateParams;
import com.stripe.param.InvoiceItemListParams;
import com.stripe.param.InvoiceItemRetrieveParams;
import com.stripe.param.InvoiceItemUpdateParams;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class InvoiceItem extends ApiResource implements HasId, MetadataStore<InvoiceItem> {
  /**
   * Amount (in the {@code currency} specified) of the invoice item. This should always be equal to
   * {@code unit_amount * quantity}.
   */
  @SerializedName("amount")
  Long amount;

  /**
   * Three-letter <a href="https://www.iso.org/iso-4217-currency-codes.html">ISO currency code</a>,
   * in lowercase. Must be a <a href="https://stripe.com/docs/currencies">supported currency</a>.
   */
  @SerializedName("currency")
  String currency;

  /** The ID of the customer who will be billed when this invoice item is billed. */
  @SerializedName("customer")
  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  ExpandableField<Customer> customer;

  /** Time at which the object was created. Measured in seconds since the Unix epoch. */
  @SerializedName("date")
  Long date;

  /** Always true for a deleted object. */
  @SerializedName("deleted")
  Boolean deleted;

  /** An arbitrary string attached to the object. Often useful for displaying to users. */
  @SerializedName("description")
  String description;

  /** If true, discounts will apply to this invoice item. Always false for prorations. */
  @SerializedName("discountable")
  Boolean discountable;

  /**
   * A discount represents the actual application of a coupon to a particular customer. It contains
   * information about when the discount began and when it will end.
   *
   * <p>Related guide: <a href="https://stripe.com/docs/billing/subscriptions/discounts">Applying
   * Discounts to Subscriptions</a>.
   */
  @SerializedName("discounts")
  Discount discounts;

  /** Unique identifier for the object. */
  @Getter(onMethod_ = {@Override})
  @SerializedName("id")
  String id;

  /** The ID of the invoice this invoice item belongs to. */
  @SerializedName("invoice")
  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  ExpandableField<Invoice> invoice;

  /**
   * Has the value {@code true} if the object exists in live mode or the value {@code false} if the
   * object exists in test mode.
   */
  @SerializedName("livemode")
  Boolean livemode;

  /**
   * Set of <a href="https://stripe.com/docs/api/metadata">key-value pairs</a> that you can attach
   * to an object. This can be useful for storing additional information about the object in a
   * structured format.
   */
  @Getter(onMethod_ = {@Override})
  @SerializedName("metadata")
  Map<String, String> metadata;

  /**
   * String representing the object's type. Objects of the same type share the same value.
   *
   * <p>Equal to {@code invoiceitem}.
   */
  @SerializedName("object")
  String object;

  @SerializedName("period")
  InvoiceLineItemPeriod period;

  /**
   * If the invoice item is a proration, the plan of the subscription that the proration was
   * computed for.
   */
  @SerializedName("plan")
  Plan plan;

  /** The price of the invoice item. */
  @SerializedName("price")
  Price price;

  /**
   * Whether the invoice item was created automatically as a proration adjustment when the customer
   * switched plans.
   */
  @SerializedName("proration")
  Boolean proration;

  /**
   * Quantity of units for the invoice item. If the invoice item is a proration, the quantity of the
   * subscription that the proration was computed for.
   */
  @SerializedName("quantity")
  Long quantity;

  /** The subscription that this invoice item has been created for, if any. */
  @SerializedName("subscription")
  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  ExpandableField<Subscription> subscription;

  /** The subscription item that this invoice item has been created for, if any. */
  @SerializedName("subscription_item")
  String subscriptionItem;

  /**
   * The tax rates which apply to the invoice item. When set, the {@code default_tax_rates} on the
   * invoice do not apply to this invoice item.
   */
  @SerializedName("tax_rates")
  List<TaxRate> taxRates;

  /**
   * For prorations this indicates whether Stripe automatically grouped multiple related debit and
   * credit line items into a single combined line item.
   */
  @SerializedName("unified_proration")
  Boolean unifiedProration;

  /** Unit Amount (in the {@code currency} specified) of the invoice item. */
  @SerializedName("unit_amount")
  Long unitAmount;

  /** Same as {@code unit_amount}, but contains a decimal value with at most 12 decimal places. */
  @SerializedName("unit_amount_decimal")
  BigDecimal unitAmountDecimal;

  /** Get ID of expandable {@code customer} object. */
  public String getCustomer() {
    return (this.customer != null) ? this.customer.getId() : null;
  }

  public void setCustomer(String id) {
    this.customer = ApiResource.setExpandableFieldId(id, this.customer);
  }

  /** Get expanded {@code customer}. */
  public Customer getCustomerObject() {
    return (this.customer != null) ? this.customer.getExpanded() : null;
  }

  public void setCustomerObject(Customer expandableObject) {
    this.customer = new ExpandableField<Customer>(expandableObject.getId(), expandableObject);
  }

  /** Get ID of expandable {@code invoice} object. */
  public String getInvoice() {
    return (this.invoice != null) ? this.invoice.getId() : null;
  }

  public void setInvoice(String id) {
    this.invoice = ApiResource.setExpandableFieldId(id, this.invoice);
  }

  /** Get expanded {@code invoice}. */
  public Invoice getInvoiceObject() {
    return (this.invoice != null) ? this.invoice.getExpanded() : null;
  }

  public void setInvoiceObject(Invoice expandableObject) {
    this.invoice = new ExpandableField<Invoice>(expandableObject.getId(), expandableObject);
  }

  /** Get ID of expandable {@code subscription} object. */
  public String getSubscription() {
    return (this.subscription != null) ? this.subscription.getId() : null;
  }

  public void setSubscription(String id) {
    this.subscription = ApiResource.setExpandableFieldId(id, this.subscription);
  }

  /** Get expanded {@code subscription}. */
  public Subscription getSubscriptionObject() {
    return (this.subscription != null) ? this.subscription.getExpanded() : null;
  }

  public void setSubscriptionObject(Subscription expandableObject) {
    this.subscription =
        new ExpandableField<Subscription>(expandableObject.getId(), expandableObject);
  }

  /**
   * Returns a list of your invoice items. Invoice items are returned sorted by creation date, with
   * the most recently created invoice items appearing first.
   */
  public static InvoiceItemCollection list(Map<String, Object> params) throws StripeException {
    return list(params, (RequestOptions) null);
  }

  /**
   * Returns a list of your invoice items. Invoice items are returned sorted by creation date, with
   * the most recently created invoice items appearing first.
   */
  public static InvoiceItemCollection list(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url = String.format("%s%s", Stripe.getApiBase(), "/v1/invoiceitems");
    return ApiResource.requestCollection(url, params, InvoiceItemCollection.class, options);
  }

  /**
   * Returns a list of your invoice items. Invoice items are returned sorted by creation date, with
   * the most recently created invoice items appearing first.
   */
  public static InvoiceItemCollection list(InvoiceItemListParams params) throws StripeException {
    return list(params, (RequestOptions) null);
  }

  /**
   * Returns a list of your invoice items. Invoice items are returned sorted by creation date, with
   * the most recently created invoice items appearing first.
   */
  public static InvoiceItemCollection list(InvoiceItemListParams params, RequestOptions options)
      throws StripeException {
    String url = String.format("%s%s", Stripe.getApiBase(), "/v1/invoiceitems");
    return ApiResource.requestCollection(url, params, InvoiceItemCollection.class, options);
  }

  /**
   * Creates an item to be added to a draft invoice. If no invoice is specified, the item will be on
   * the next invoice created for the customer specified.
   */
  public static InvoiceItem create(Map<String, Object> params) throws StripeException {
    return create(params, (RequestOptions) null);
  }

  /**
   * Creates an item to be added to a draft invoice. If no invoice is specified, the item will be on
   * the next invoice created for the customer specified.
   */
  public static InvoiceItem create(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url = String.format("%s%s", Stripe.getApiBase(), "/v1/invoiceitems");
    return ApiResource.request(
        ApiResource.RequestMethod.POST, url, params, InvoiceItem.class, options);
  }

  /**
   * Creates an item to be added to a draft invoice. If no invoice is specified, the item will be on
   * the next invoice created for the customer specified.
   */
  public static InvoiceItem create(InvoiceItemCreateParams params) throws StripeException {
    return create(params, (RequestOptions) null);
  }

  /**
   * Creates an item to be added to a draft invoice. If no invoice is specified, the item will be on
   * the next invoice created for the customer specified.
   */
  public static InvoiceItem create(InvoiceItemCreateParams params, RequestOptions options)
      throws StripeException {
    String url = String.format("%s%s", Stripe.getApiBase(), "/v1/invoiceitems");
    return ApiResource.request(
        ApiResource.RequestMethod.POST, url, params, InvoiceItem.class, options);
  }

  /** Retrieves the invoice item with the given ID. */
  public static InvoiceItem retrieve(String invoiceitem) throws StripeException {
    return retrieve(invoiceitem, (Map<String, Object>) null, (RequestOptions) null);
  }

  /** Retrieves the invoice item with the given ID. */
  public static InvoiceItem retrieve(String invoiceitem, RequestOptions options)
      throws StripeException {
    return retrieve(invoiceitem, (Map<String, Object>) null, options);
  }

  /** Retrieves the invoice item with the given ID. */
  public static InvoiceItem retrieve(
      String invoiceitem, Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url =
        String.format(
            "%s%s",
            Stripe.getApiBase(),
            String.format("/v1/invoiceitems/%s", ApiResource.urlEncodeId(invoiceitem)));
    return ApiResource.request(
        ApiResource.RequestMethod.GET, url, params, InvoiceItem.class, options);
  }

  /** Retrieves the invoice item with the given ID. */
  public static InvoiceItem retrieve(
      String invoiceitem, InvoiceItemRetrieveParams params, RequestOptions options)
      throws StripeException {
    String url =
        String.format(
            "%s%s",
            Stripe.getApiBase(),
            String.format("/v1/invoiceitems/%s", ApiResource.urlEncodeId(invoiceitem)));
    return ApiResource.request(
        ApiResource.RequestMethod.GET, url, params, InvoiceItem.class, options);
  }

  /**
   * Updates the amount or description of an invoice item on an upcoming invoice. Updating an
   * invoice item is only possible before the invoice it’s attached to is closed.
   */
  @Override
  public InvoiceItem update(Map<String, Object> params) throws StripeException {
    return update(params, (RequestOptions) null);
  }

  /**
   * Updates the amount or description of an invoice item on an upcoming invoice. Updating an
   * invoice item is only possible before the invoice it’s attached to is closed.
   */
  @Override
  public InvoiceItem update(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url =
        String.format(
            "%s%s",
            Stripe.getApiBase(),
            String.format("/v1/invoiceitems/%s", ApiResource.urlEncodeId(this.getId())));
    return ApiResource.request(
        ApiResource.RequestMethod.POST, url, params, InvoiceItem.class, options);
  }

  /**
   * Updates the amount or description of an invoice item on an upcoming invoice. Updating an
   * invoice item is only possible before the invoice it’s attached to is closed.
   */
  public InvoiceItem update(InvoiceItemUpdateParams params) throws StripeException {
    return update(params, (RequestOptions) null);
  }

  /**
   * Updates the amount or description of an invoice item on an upcoming invoice. Updating an
   * invoice item is only possible before the invoice it’s attached to is closed.
   */
  public InvoiceItem update(InvoiceItemUpdateParams params, RequestOptions options)
      throws StripeException {
    String url =
        String.format(
            "%s%s",
            Stripe.getApiBase(),
            String.format("/v1/invoiceitems/%s", ApiResource.urlEncodeId(this.getId())));
    return ApiResource.request(
        ApiResource.RequestMethod.POST, url, params, InvoiceItem.class, options);
  }

  /**
   * Deletes an invoice item, removing it from an invoice. Deleting invoice items is only possible
   * when they’re not attached to invoices, or if it’s attached to a draft invoice.
   */
  public InvoiceItem delete() throws StripeException {
    return delete((Map<String, Object>) null, (RequestOptions) null);
  }

  /**
   * Deletes an invoice item, removing it from an invoice. Deleting invoice items is only possible
   * when they’re not attached to invoices, or if it’s attached to a draft invoice.
   */
  public InvoiceItem delete(RequestOptions options) throws StripeException {
    return delete((Map<String, Object>) null, options);
  }

  /**
   * Deletes an invoice item, removing it from an invoice. Deleting invoice items is only possible
   * when they’re not attached to invoices, or if it’s attached to a draft invoice.
   */
  public InvoiceItem delete(Map<String, Object> params) throws StripeException {
    return delete(params, (RequestOptions) null);
  }

  /**
   * Deletes an invoice item, removing it from an invoice. Deleting invoice items is only possible
   * when they’re not attached to invoices, or if it’s attached to a draft invoice.
   */
  public InvoiceItem delete(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url =
        String.format(
            "%s%s",
            Stripe.getApiBase(),
            String.format("/v1/invoiceitems/%s", ApiResource.urlEncodeId(this.getId())));
    return ApiResource.request(
        ApiResource.RequestMethod.DELETE, url, params, InvoiceItem.class, options);
  }

  @Getter
  @Setter
  @EqualsAndHashCode(callSuper = false)
  public static class Discount extends StripeObject implements HasId {
    /**
     * A coupon contains information about a percent-off or amount-off discount you might want to
     * apply to a customer. Coupons may be applied to <a
     * href="https://stripe.com/docs/api#invoices">invoices</a> or <a
     * href="https://stripe.com/docs/api#create_order-coupon">orders</a>. Coupons do not work with
     * conventional one-off <a href="https://stripe.com/docs/api#create_charge">charges</a>.
     */
    @SerializedName("coupon")
    Coupon coupon;

    /** The ID of the customer associated with this discount. */
    @SerializedName("customer")
    @Getter(lombok.AccessLevel.NONE)
    @Setter(lombok.AccessLevel.NONE)
    ExpandableField<Customer> customer;

    /** Always true for a deleted object. */
    @SerializedName("deleted")
    Boolean deleted;

    /**
     * If the coupon has a duration of {@code repeating}, the date that this discount will end. If
     * the coupon has a duration of {@code once} or {@code forever}, this attribute will be null.
     */
    @SerializedName("end")
    Long end;

    /**
     * The ID of the discount object. Discounts cannot be fetched by ID. Use {@code
     * expand[]=discounts} in API calls to expand discount IDs in an array.
     */
    @Getter(onMethod_ = {@Override})
    @SerializedName("id")
    String id;

    /**
     * The invoice that the discount's coupon was applied to, if it was applied directly to a
     * particular invoice.
     */
    @SerializedName("invoice")
    String invoice;

    /**
     * The invoice item {@code id} (or invoice line item {@code id} for invoice line items of
     * type='subscription') that the discount's coupon was applied to, if it was applied directly to
     * a particular invoice item or invoice line item.
     */
    @SerializedName("invoice_item")
    String invoiceItem;

    /**
     * String representing the object's type. Objects of the same type share the same value.
     *
     * <p>Equal to {@code discount}.
     */
    @SerializedName("object")
    String object;

    /** The promotion code applied to create this discount. */
    @SerializedName("promotion_code")
    @Getter(lombok.AccessLevel.NONE)
    @Setter(lombok.AccessLevel.NONE)
    ExpandableField<PromotionCode> promotionCode;

    /** Date that the coupon was applied. */
    @SerializedName("start")
    Long start;

    /**
     * The subscription that this coupon is applied to, if it is applied to a particular
     * subscription.
     */
    @SerializedName("subscription")
    String subscription;

    /** Get ID of expandable {@code customer} object. */
    public String getCustomer() {
      return (this.customer != null) ? this.customer.getId() : null;
    }

    public void setCustomer(String id) {
      this.customer = ApiResource.setExpandableFieldId(id, this.customer);
    }

    /** Get expanded {@code customer}. */
    public Customer getCustomerObject() {
      return (this.customer != null) ? this.customer.getExpanded() : null;
    }

    public void setCustomerObject(Customer expandableObject) {
      this.customer = new ExpandableField<Customer>(expandableObject.getId(), expandableObject);
    }

    /** Get ID of expandable {@code promotionCode} object. */
    public String getPromotionCode() {
      return (this.promotionCode != null) ? this.promotionCode.getId() : null;
    }

    public void setPromotionCode(String id) {
      this.promotionCode = ApiResource.setExpandableFieldId(id, this.promotionCode);
    }

    /** Get expanded {@code promotionCode}. */
    public PromotionCode getPromotionCodeObject() {
      return (this.promotionCode != null) ? this.promotionCode.getExpanded() : null;
    }

    public void setPromotionCodeObject(PromotionCode expandableObject) {
      this.promotionCode =
          new ExpandableField<PromotionCode>(expandableObject.getId(), expandableObject);
    }
  }

  @Getter
  @Setter
  @EqualsAndHashCode(callSuper = false)
  public static class InvoiceLineItemPeriod extends StripeObject {
    /** End of the line item's billing period. */
    @SerializedName("end")
    Long end;

    /** Start of the line item's billing period. */
    @SerializedName("start")
    Long start;
  }
}
