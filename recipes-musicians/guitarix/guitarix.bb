SUMMARY = "A virtual guitar amplifier"
HOMEPAGE = "http://guitarix.org/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=384f45fb7968a0fe30622ce6160d3b69"

PV = "0.39.0"
SRC_URI = "${SOURCEFORGE_MIRROR}/project/${BPN}/${BPN}/${BPN}2-${PV}.tar.xz"
SRC_URI[md5sum] = "04c22ff9baaa69d256e2ca84ba288936"
SRC_URI[sha256sum] = "490ff3f856282f776456b8e27366dd074d663870c0a89fccded03d854305c8da"

inherit waf fontcache gettext

DEPENDS += " \
    gperf-native \
    intltool-native \
    faust-native \
    boost \
    libeigen \
    avahi \
    gtkmm \
    jack \
    lilv \
    ladspa-sdk \
    libsndfile1 \
    lrdf \
    zita-resampler \
    zita-convolver \
"

PACKAGECONFIG[bluez] = ",--no-bluez,bluez5"

EXTRA_OECONF = " \
    --disable-sse \
    --bindir=${bindir} \
    --libdir=${libdir} \
    --ldflags="${LDFLAGS}" \
    --no-ldconfig \
    --no-desktop-update \
    --shared-lib \
    --lib-dev \
    --install-roboto-font \
"

python waf_preconfigure() {
}

do_configure_prepend() {
    for pfile in `grep -rl '/usr/bin/env python$' ${S}`; do
        sed -i 's:/usr/bin/env python:/usr/bin/env python3:' $pfile
    done
}

do_install_append() {
    # some corrections [dev-elf] - inspired by https://src.fedoraproject.org/rpms/guitarix/blob/master/f/guitarix.spec
    chmod 755 ${D}${libdir}/libgxw*.so.0.1
    rm -rf ${D}${libdir}/libgxw*.so
    ln -sf libgxwmm.so.0.1 ${D}${libdir}/libgxwmm.so
    ln -sf libgxw.so.0.1 ${D}${libdir}/libgxw.so
}

FILES_${PN} += " \
    ${datadir}/fonts \
    ${datadir}/gx_head \
    ${datadir}/ladspa \
    ${libdir}/ladspa \
    ${libdir}/lv2 \
"
