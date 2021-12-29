import { React, useEffect } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import dayjs from 'dayjs';
import relativeTime from 'dayjs/plugin/relativeTime';
import { fetchAllAsync } from './userSlice';

import styles from './User.module.css';

dayjs.extend(relativeTime);

const dateFormat = (date) => dayjs(date).format('YYYY/MM/DD');
const timeFormat = (date) => dayjs().to(date);

export function User() {
    const { list, status } = useSelector((rootState) => rootState.user);
    const dispatch = useDispatch();

    useEffect(() => {
        (async () => dispatch(fetchAllAsync()))();
    }, []);

    return (
        <div>
            <table className={styles.datagrid}>
                <thead>
                    <tr>
                        <th></th>
                        <th>姓名</th>
                        <th>创建时间</th>
                        <th>修改时间</th>
                    </tr>
                </thead>
                <tbody>
                    {list.map(it => (
                        <tr key={it.id}>
                            <td>{it.id}</td>
                            <td>{it.name}</td>
                            <td>{dateFormat(it.createdAt)}</td>
                            <td>{timeFormat(it.updatedAt)}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
            <div className={styles.status}>status: {status}</div>
        </div>
    );
}