const modal = $('#add-point-modal');
const amount = $('#point-input');
const addPointPath = '/api/recypoints/add'
const buttonSave = $('#btn-save');
const providerId = $('#provider-id').data("provider_id");
let userId;

const getAmountTdById = (id) => {
    return document.getElementById(`amount-${id}`);
}

const sendData = () => {
    request({
            url: `${addPointPath}/${userId}`,
            method: 'PUT',
            body: JSON.stringify({
                provider: providerId,
                beneficiary: userId,
                amount: parseInt(amount.val())
            }),
            headers: {
                "Content-Type": "application/json"
            }
        }
    ).then(data => {
        data = JSON.parse(data);
        const amountTd = getAmountTdById(userId);
        amountTd.innerText = data.amount;
    });
}

function addPoint(el) {
    const jqueryEl = $(el);
    userId = jqueryEl.data("user_id");
    modal.modal({});
    buttonSave.click(sendData);
}