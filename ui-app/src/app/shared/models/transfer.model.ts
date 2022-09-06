export interface ITransfer{
    originAccount: string,
    destinationAccount: string,
    value: string
    requestedDate: string,
    scheduledDate: string,
    finalValue: string
    fee: string
}