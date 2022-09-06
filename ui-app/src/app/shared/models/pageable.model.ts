export interface IPage<T> {
    content: T[],
    pageable: IPageable,
    last: boolean,
    totalPages: number,
    totalElements: number,
    size: number,
    number: number,
    sort: ISort,
    first: boolean,
    numberOfElements: number,
    empty: boolean
}

interface IPageable {
    sort: ISort,
    offset: number,
    pageSize: number,
    pageNumber: number,
    unpaged: boolean,
    paged: boolean
}

interface ISort {
    empty: boolean,
    sorted: boolean,
    unsorted: boolean
}